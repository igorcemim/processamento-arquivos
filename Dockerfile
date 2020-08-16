FROM gradle:6.6-jdk11
COPY ./ /app
WORKDIR /app
RUN gradle bootJar