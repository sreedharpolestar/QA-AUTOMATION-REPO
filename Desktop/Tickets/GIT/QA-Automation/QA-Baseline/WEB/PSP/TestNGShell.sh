#!/bin/bash
cd C:/Users/sreedhar.popuri/workspace/selenium/PSP_Automation/PSP_Automation_Project
export ProjectPath=C:/Users/sreedhar.popuri/workspace/selenium/PSP_Automation/PSP_Automation_Project
echo $ProjectPath$
export classpath=$ProjectPath%/bin;%ProjectPath%/lib/*
echo $classpath$
java org.testng.TestNG $ProjectPath$/testng.xml