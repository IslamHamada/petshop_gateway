node {
    def repourl = "islamhamada/petshop"
    def mvnHome = tool name: 'maven', type: 'maven'
    def mvnCMD = "${mvnHome}/bin/mvn"
    def version = sh(script: "date +%s", returnStdout: true).trim()
    stage("Checkout"){
        checkout([$class: 'GitSCM',
         branches: [[name: '*/hetzner']],
         userRemoteConfigs: [[credentialsId: 'git',
         url: 'https://github.com/IslamHamada/petshop_gateway.git']]])
    }
    stage("Build and Push Image"){
        withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
            sh("${mvnCMD} clean install jib:build -DREPO_URL=${repourl} -DVERSION=${version} -Djib.to.auth.username=$DOCKER_USER -Djib.to.auth.password=$DOCKER_PASS")
        }
    }
    stage("Deploy"){
        sh("sed -i 's|IMAGE_URL|${repourl}|g' k8s/deployment.yaml")
        sh("sed -i 's|TAG|${version}|g' k8s/deployment.yaml")
        step([$class: 'KubernetesEngineBuilder',
            projectId: env.PROJECT_ID,
            clusterName: env.CLUSTER,
            location: env.ZONE,
            manifestPattern: 'k8s/deployment.yaml',
            credentialsId: env.PROJECT_ID,
            verifyDeployments: true])
        step([$class: 'KubernetesEngineBuilder',
              projectId: env.PROJECT_ID,
              clusterName: env.CLUSTER,
              location: env.ZONE,
              manifestPattern: 'k8s/cert.yaml',
              credentialsId: env.PROJECT_ID,
              verifyDeployments: true])
    }
}