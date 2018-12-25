@echo off
set PATH=%PATH%;C:\Archivos de programa\Java\jdk\jrockit-R27.4.0-jdk1.5.0_12\bin

set basedir=%~f0
:strip
set removed=%basedir:~-1%
set basedir=%basedir:~0,-1%
if NOT "%removed%"=="\" goto strip
set PROGRAM_HOME=%basedir%

dir /b /s "%PROGRAM_HOME%\lib\*.jar" > temp.tmp

FOR /F %%I IN (temp.tmp) DO CALL "%PROGRAM_HOME%\addpath.bat" %%I
cd %PROGRAM_HOME%
D:
start /b javaw -Dlog4j.configuration=..\postgrado_businesslogic\src\propiedades\log4j.properties -cp %TMP_CP% de.simplicit.vjdbc.server.rmi.ConnectionServer "..\postgrado_businesslogic\src\propiedades\vjdbc_server_config.xml" "..\postgrado_businesslogic\src\propiedades\databaseNative.properties"
exit