@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.  See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership.  The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM "License"); you may not use this file except in compliance
@REM with the License.  You may obtain a copy of the License at
@REM
@REM    https://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on an
@REM "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied.  See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@REM Apache Maven Wrapper startup batch script, version 3.3.2

@IF "%__MVNW_ARG0_NAME__%"=="" (SET "BASE_DIR=%~dp0") ELSE (SET "BASE_DIR=%__MVNW_ARG0_NAME__%")
@SET MAVEN_PROJECTBASEDIR=%BASE_DIR%
@SET WRAPPER_JAR=%BASE_DIR%.mvn\wrapper\maven-wrapper.jar
@SET WRAPPER_PROPERTIES=%BASE_DIR%.mvn\wrapper\maven-wrapper.properties

@SET WRAPPER_URL=
@FOR /F "usebackq tokens=1,2 delims==" %%a IN ("%WRAPPER_PROPERTIES%") DO @(
    IF "%%a"=="wrapperUrl" SET WRAPPER_URL=%%b
)

@IF NOT EXIST "%WRAPPER_JAR%" (
    @ECHO Downloading %WRAPPER_URL%...
    @curl -s -o "%WRAPPER_JAR%" "%WRAPPER_URL%"
)

@"%JAVA_HOME%\bin\java.exe" ^
  %MAVEN_OPTS% ^
  -classpath "%WRAPPER_JAR%" ^
  "-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%" ^
  "org.apache.maven.wrapper.MavenWrapperMain" %*
