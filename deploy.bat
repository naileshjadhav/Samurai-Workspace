set "tomcat_path=D:\Software\apache-tomcat-9.0.33\webapps"
set "target_path=C:\Program Files (x86)\Jenkins\workspace\pipeline-test\target"
xcopy "%target_path%" "%tomcat_path%"
