FROM openjdk:18
COPY ./out/production/accunknox/ /tmp
COPY log.txt /tmp
WORKDIR /tmp
ENTRYPOINT ["java","function"]