# Create-JRE-using-Docker-Example
Create a minimal JRE around a Maven project and ship it as ***lightweight*** Docker image

 ![Docker Images Snapshot](https://github.com/newfla/Create-JRE-using-Docker/blob/main/res/docker_images_snap.png?raw=true) 
## Repository content
- **/server** folder contains a *lazy Hello-World* webserver based on [Javalin](https://github.com/tipsy/javalin).
The code is packaged as single Jar using the [maven-assembly-plugin](https://maven.apache.org/plugins/maven-assembly-plugin/)
    - *run.sh* is the entrypoint for the dockerized application

- **Dockerfile** describes *4* images based on the *blazing fast* [GraalVM CE JDK](https://github.com/oracle/graal/) artifact:

    1. **base_image**: [Ubuntu 22.04 docker image](https://hub.docker.com/layers/library/ubuntu/jammy/images/sha256-42ba2dfce475de1113d55602d40af18415897167d47c2045ec7b6d9746ff148f?context=explore) + [GraalVM CE JDK](https://github.com/oracle/graal/)

    2. **server_builder**: builds the maven project and creates the minimal JRE. Base modules are discovered using [jdeps](https://docs.oracle.com/en/java/javase/11/tools/jdeps.html) and exported as JRE distribution by [jlink](https://docs.oracle.com/en/java/javase/11/tools/jlink.html)

    ![Docker Minimal JRE Image Snapshot](https://github.com/newfla/Create-JRE-using-Docker/blob/main//res/minimal_jre_snap.png?raw=true)

    2. **minimal_jre_image**: ships the minimal JRE for the server application

    3. **jdk_image**: contains the whole GraalVM JDK 

# Size reduction
| Image  | Size  | vs JDK | vs JRE  |
|--------|-------|--------|---------
| JDK    | 835MB | -      | 618%    |
| JRE    | 135MB | 16%    | -       |

    
**The jre based image is 84% smaller than the optimized-jre one**


# Start-up time reduction

| Image  | Time  | vs JDK | vs JRE  |
|--------|-------|--------|---------|
| JDK    | 502ms | -      | 127%    |
| JRE    | 395ms | 78%    | -       |

**The jre based image is 22% faster to start-up than the optimized-jre one**
