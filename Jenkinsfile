@Library('SampleGroovy') _

pipeline{
    agent any
	triggers {
        cron('*/5 * * * *')
    }
    stages{

        stage('Demo'){

             steps{
            testlib("Abhinandan")
        }

        }

    }
}