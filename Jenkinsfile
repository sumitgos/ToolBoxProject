	node{
    stage('SCM Checkout'){
		git 'https://github.com/sumitgos/ToolBoxProject/new/master'
		}
	
	stage('Compile-Package'){
		sh 'mvn package'
	}
}
