package com.abhi.test

import java.time.LocalDateTime
import java.time.Month
import java.time.temporal.TemporalAdjusters


def flag=false

def currDate = LocalDate.now()
def thirdDay = currDate.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SUNDAY));

if (currDate.equals(thirdDay)){
    flag = true
}

if (flag = true){

    pipeline{
        agent{
            label "node"
        }
        stages{
            stage("A"){
                steps{
                    echo "========executing A========"
                }
                post{
                    always{
                        echo "========always========"
                    }
                    success{
                        echo "========A executed successfully========"
                    }
                    failure{
                        echo "========A execution failed========"
                    }
                }
            }
        }
        post{
            always{
                echo "========always========"
            }
            success{
                echo "========pipeline executed successfully ========"
            }
            failure{
                echo "========pipeline execution failed========"
            }
        }
    }

}else {



pipeline {
    agent any

    environment {
        name = 'Abhinandan'
    }

    parameters {
        string(name: 'City', defaultValue: 'pune', description: "Enter your City name" )
        booleanParam(name: 'isMale', defaultValue: 'true', description: "Enter your gender" )
        choice(name: 'FavCity', choices:['pune','mumbai','delhi'],description: "select your fav City")
    }

    stages {
        stage('Test') {
            steps {
                echo 'Hello World'
            }
        }
        stage('windows bat command run') {

            environment{
                name = 'ram'
            }

            steps {
                bat '''dir'''
                bat 'echo  "%name%"'
            }
        }
        stage('Jenkins Environment variable') {
            steps {
                bat 'echo  "%BUILD_ID%"'
                bat 'echo  "%name%"'
            }
        }
        stage('take paramter from User') {
            steps {
                bat 'echo  "%City%"'

            }
        }
        stage('continue ?') {

            input{
                message "Should we continue ?"
                ok "Yes we should"
            }

            steps {
                bat 'echo  "%City%"'

            }
        }

    }
    post{
        always{

            echo 'it is like finally block'

        }
        failure{
            echo 'after successful'
        }
        success{
            echo 'after failure'
        }
    }
}
}