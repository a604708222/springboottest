// 公共
def registry = "192.168.47.59"
// 项目
def project = "zouqiang"
def app_name = "springboottest"
def image_name = "${registry}/${project}/${app_name}:${BUILD_NUMBER}"
def git_address = "https://github.com/a604708222/springboottest.git"
def jar_name = "springbootTest-0.0.1-SNAPSHOT.jar"
// 认证
def secret_name = "registry-pull-secret"
def docker_registry_auth = "2f0350e1-d160-4c1c-9b97-7abdd74c4ceb"
def git_auth = "c4d3bb40-24b3-4c1f-9cd9-b48d47a74923"
def k8s_auth = "25ede8d6-dc22-4f59-a6a7-c0c219052dd0"

podTemplate(label: 'jenkins-slave', cloud: 'kubernetes', containers: [
    containerTemplate(
        name: 'jnlp', 
        image: "${registry}/library/jenkins-slave-jdk:1.0"
    ),
  ],
  volumes: [
    hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
    hostPathVolume(mountPath: '/usr/bin/docker', hostPath: '/usr/bin/docker')
  ],
) 
{
  node("jenkins-slave"){
      // 第一步
      stage('拉取代码'){
		 checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_address}"]]])
         //checkout([$class: 'GitSCM', branches: [[name: '${Branch}']], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_address}"]]])
      }
      // 第二步
      stage('代码编译'){
          sh "mvn clean package -Dmaven.test.skip=true"
		  sh "pwd"
		  sh "ls"
      }
      // 第三步
      stage('构建镜像'){
          //withCredentials([usernamePassword(credentialsId: "${docker_registry_auth}", passwordVariable: 'password', usernameVariable: 'username')]) {
		  //withCredentials([usernamePassword(credentialsId: '${docker_registry_auth}', passwordVariable: 'harborpassword', usernameVariable: 'harborusername')]) {
		  withCredentials([usernamePassword(credentialsId: "${docker_registry_auth}", passwordVariable: 'harborpassword', usernameVariable: 'harborusername')]) {
            sh """
			  
			  sed -i 's#\$REGISTRY#${registry}#' Dockerfile
			  sed -i 's#\$JAR_NAME#${jar_name}#' start.sh
			  chmod +x  start.sh
			  
              docker login -u ${harborusername} -p '${harborpassword}' ${registry}
			  docker build -t ${image_name} .
              docker push ${image_name}
            """
            }
      }
      // 第四步
      stage('部署到K8S平台'){
          sh """
          sed -i 's#\$IMAGE_NAME#${image_name}#' deploy.yaml
          sed -i 's#\$SECRET_NAME#${secret_name}#' deploy.yaml
          """
          //kubernetesDeploy configs: 'deploy.yml', kubeconfigId: "${k8s_auth}"
		  
		  kubernetesDeploy configs: 'deploy.yaml', kubeConfig: [path: ''], kubeconfigId: "${k8s_auth}", secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
      }
  }
}
