set ProjectPath=C:\Users\sreedhar.popuri\workspace\selenium\PSP_Automation\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project
echo %ProjectPath% "C:\Users\sreedhar.popuri\workspace\selenium\PSP_Automation\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project"
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*
echo %classpath% C:\Users\sreedhar.popuri\workspace\selenium\PSP_Automation\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\PSP_Automation_Project\lib\*
java org.testng.TestNG %ProjectPath%\testng.xml
pause

