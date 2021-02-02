pipeline {
    agent any

    stages 
    {
        stage ('Install Software') {
            steps {
                build job: 'ansible_job'
            }
        }
        
        stage ('Pull Image') {
            steps {
                build job: 'ansible_pull_website'
            }
        }
        
        stage ('Build Image') {
            steps {
                build job: 'ansible_build_website'
            }
        }
        
        stage ('Test Deployment') {
            steps {
                build job: 'website_testing'
            }
            
            post{
                failure {
                    build job: 'undeploy_website'
                }
                unstable {
                    build job: 'undeploy_website'
                }
            }            
        }
    }
}
