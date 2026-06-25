#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#    https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
# ----------------------------------------------------------------------------

# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup batch script, version 3.3.2
# ----------------------------------------------------------------------------

# If specified, validates and uses the configured Maven version
if [ -n "$MVNW_REPOURL" ]; then
  MVNW_REPO_PATTERN=$(printf %s "$MVNW_REPOURL" | sed "s/.*\(maven-wrapper\).*/\1/")
fi

# Find the project base dir, i.e. the closest parent dir of the current dir
# that has the mvnw file itself.
find_maven_basedir() {
  if [ -z "$1" ]; then
    echo "Path not specified to find_maven_basedir"
    return 1
  fi

  basedir="$1"
  wrapperJarPath="$basedir/.mvn/wrapper/maven-wrapper.jar"
  propertiesPath="$basedir/.mvn/wrapper/maven-wrapper.properties"

  while [ "$basedir" != "/" ]; do
    if [ -f "$propertiesPath" ]; then
      break
    fi
    # workaround for the behavior of some versions of `dirname` on macOS
    _basedir="$(dirname "$basedir")"
    if [ "$_basedir" = "$basedir" ]; then
      break
    fi
    basedir="$_basedir"
  done

  echo "$basedir"
}

# Fallback to using the directory of the mvnw script itself
MAVEN_BASEDIR="$(find_maven_basedir "$(dirname "$0")")"
MAVEN_PROJECTBASEDIR="${MAVEN_BASEDIR}"

if [ -z "$MAVEN_BASEDIR" ]; then
  echo "ERROR: project directory could not be determined."
  exit 1
fi

MAVEN_OPTS="${MAVEN_OPTS:-}"

# Download the maven-wrapper.jar if it's not already there.
download_maven_wrapper_jar() {
  wrapperJarPath="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar"
  if [ -f "$wrapperJarPath" ]; then
    return
  fi

  wrapperUrl="$(grep -E "^wrapperUrl=" "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties" | tail -n 1 | sed -e 's/.*=//')"
  while IFS="=" read -r key value; do
    # ignore everything that is not a url property
    case "$key" in
    wrapperUrl)
      wrapperUrl="$value"
      break
      ;;
    esac
  done <"$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties"

  echo "Downloading $wrapperUrl..."
  if ! curl -s -o "$wrapperJarPath" "$wrapperUrl"; then
    if ! wget -O "$wrapperJarPath" "$wrapperUrl"; then
      echo "ERROR: Cannot download the Maven wrapper jar."
      exit 1
    fi
  fi
}

download_maven_wrapper_jar

exec "$JAVA_HOME/bin/java" \
  $MAVEN_OPTS \
  -classpath "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" \
  "-Dmaven.multiModuleProjectDirectory=$MAVEN_PROJECTBASEDIR" \
  "org.apache.maven.wrapper.MavenWrapperMain" "$@"
