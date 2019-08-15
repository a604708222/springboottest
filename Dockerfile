FROM $REGISTRY/zouqiang/centos_jdk:2.0
COPY start.sh /usr/local/
COPY target/*.jar /usr/local/
CMD "/usr/local/start.sh"