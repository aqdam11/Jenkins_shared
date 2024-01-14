def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=239d1af2acmshee08c404c7d2a43p13d6cajsn20bd2ae77c2f -t ${dockerimage} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${dockerimage}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker']) {
        sh "docker push ${dockerHubUsername}/${dockerimage}:latest"
    }
}
