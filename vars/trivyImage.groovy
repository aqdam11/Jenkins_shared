def call() {
    sh 'trivy image aqdamrahman/youtube:latest > trivyimage.txt'
}
