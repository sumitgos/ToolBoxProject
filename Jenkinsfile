	node{
    stage('SCM Checkout'){
	    tool name: 'MAVEN_HOME', type: 'maven'
		git 'https://github.com/sumitgos/ToolBoxProject'
		}
	
	stage('Compile-Package'){
		sh 'mvn package'
	}
}
