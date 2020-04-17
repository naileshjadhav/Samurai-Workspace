pipeline{
	agent any
	stages{
		stage('BUILD'){
			steps{
				echo 'Step build executing.....'
				mvn clean install
				echo 'build executing completed.....'
			}
		}
		stage('Test'){
			steps{
				echo 'All testcases needs to be executing.....'
			}
		}
		stage('QA'){
			steps{
				echo 'Step QA executing.....'
				echo 'All testcases needs to be executing.....'
			}
		}
		stage('Deploy'){
			steps{
				echo 'Step deploy executing.....'
				cd target
				copy *.war d:\Software\apache-tomcat-9.0.33\webapps 
				echo 'Deploy executing completed.....'
			}
		}
	}
}
