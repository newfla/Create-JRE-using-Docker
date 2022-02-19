# Create-JRE-using-Docker-Example
Create a minimal JRE around a Maven project and ship it as ***lightweight*** Docker image

 ![Docker Images Snapshot](https://github.com/newfla/Create-JRE-using-Docker/blob/main/res/docker_images_snap.png?raw=true) 
## Repository content
- **/server** folder contains a *lazy Hello-World* webserver based on [Javalin](https://github.com/tipsy/javalin).
The code is packaged as single Jar using the [maven-assembly-plugin](https://maven.apache.org/plugins/maven-assembly-plugin/)
    - *run.sh* is the entrypoint for the dockerized application

- **Dockerfile** describes *4* images based on the *blazing fast* [GraalVM CE JDK](https://github.com/oracle/graal/) artifact:

    1. **base_image**: [Ubuntu 20.04 docker image](https://hub.docker.com/layers/ubuntu/library/ubuntu/hirsute/images/sha256-cb92f03e258f965442b883f5402b310dd7a5ea0a661a865ad02a42bc21234bf7?context=explore) + [GraalVM CE JDK](https://github.com/oracle/graal/)

    2. **server_builder**: builds the maven project and creates the minimal JRE. Base modules are discovered using [jdeps](https://docs.oracle.com/en/java/javase/11/tools/jdeps.html) and exported as JRE distribution by [jlink](https://docs.oracle.com/en/java/javase/11/tools/jlink.html)

    ![Docker Minimal JRE Image Snapshot](https://github.com/newfla/Create-JRE-using-Docker/blob/main//res/minimal_jre_snap.png)

    2. **minimal_jre_image**: ships the minimal JRE for the server application

    3. **jdk_image**: contains the whole GraalVM JDK 