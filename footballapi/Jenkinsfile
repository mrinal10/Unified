pipeline {
  agent any
      
  stages {
    stage ('Maven Build') {
      steps {
       	sh "mvn -version"
       	sh "mvn clean install"
      }
    }
    
    stage ('Build Docker Image and Push to DTR') {
      when {
        anyOf {
          branch 'master'
        }
	  }
      steps {
        unstash 'artifacts'
        glDockerImageBuildPush credentialsId: dockerCredentialsId, tag:"$tagBaseVersion.${BUILD_NUMBER}-$c_branch"
      }
    }
  }
  post {
    failure {
      glGitGetInfo()
      emailext body:  "A Build for URL: ${BUILD_URL} has failed. Please review.",
        subject: "$currentBuild.currentResult: $JOB_NAME",
        to: "$GIT_AUTHOR_EMAIL"
    }
  }
}