FROM $REGISTRY/yx20/zouqiang/centos_jdk:2.0
COPY target/*.jar /usr/local/
WORKDIR /usr/local/
EXPOSE 8092
CMD ["java","-jar","$JAR_NAME"]