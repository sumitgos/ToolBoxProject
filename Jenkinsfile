	node{
    stage('SCM Checkout'){
	   
		git 'https://github.com/sumitgos/ToolBoxProject'
		}
	
	stage('Compile-Package'){
		 def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
		sh "${mvnHome/bin/mvn package}"
	}
}
