FROM openjdk:18
COPY ./out/production/accunknox/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","function"]