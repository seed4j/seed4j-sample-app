#!/bin/bash

GIT_MAIN_BRANCH='main'
GIT_REMOTE='upstream'

applyModules() {
  for module in $@
  do
    local api="/api/modules/$module/apply-patch"

    echo "curl -o /dev/null -s -w "%{http_code}\n" \
      -X POST \
      -H "accept: */*" \
      -H "Content-Type: application/json" \
      -d "$payload" \
      "http://localhost:1339""$api""

    local status_code=$(curl -o /dev/null -s -w "%{http_code}\n" \
      -X POST \
      -H "accept: */*" \
      -H "Content-Type: application/json" \
      -d "$payload" \
      "http://localhost:1339""$api")

    if [[ $status_code == '40'* || $status_code == '50'* ]]; then
      echo "Error when calling API:" "$status_code" "$api"
      exit 1
    fi;
  done
}

if [ "$#" -ne 1 ]; then
  show_syntax
fi

payload="$(sed -e "s?SEED4J_SAMPLE_APP_FOLDER?$(pwd)?g" seed4jsample.json)"

echo "*** Checking service health..."
health_status=$(curl -s http://localhost:1339/management/health | jq -r '.status')

if [[ "$health_status" != "UP" ]]; then
  echo "Service is not healthy: $health_status"
  exit 1
fi

echo "*** Git: update project..."
git switch $GIT_MAIN_BRANCH
git fetch $GIT_REMOTE
git rebase $GIT_REMOTE/$GIT_MAIN_BRANCH

echo "*** Deleting files and folders..."
find . -maxdepth 1 \
  -not -name "generate.sh" \
  -not -name "release.sh" \
  -not -name "seed4jsample.json" \
  -type f -delete
rm -rf src
rm -rf node_modules
rm -rf documentation .husky .seed4j .mvn

echo "*** Applying modules..."

applyModules \
  "init" \
  "maven-java" \
  "maven-wrapper" \
  "java-base" \
  "jacoco-with-min-coverage-check" \
  "java-memoizers" \
  "java-enums" \
  "pagination-domain"

applyModules \
  "application-service-hexagonal-architecture-documentation"

applyModules \
  "spring-boot" \
  "logs-spy" \
  "spring-boot-mvc-empty" \
  "spring-boot-tomcat" \
  "spring-boot-actuator" \
  "spring-boot-async" \
  "spring-boot-devtools" \
  "java-archunit" \
  "git-information"

applyModules \
  "prettier" \
  "typescript" \
  "frontend-maven-plugin" \
  "vue-core" \
  "vue-router"

applyModules \
  "sonarqube-java-backend-and-frontend"

applyModules \
  "datasource-postgresql" \
  "jpa-postgresql" \
  "liquibase"

applyModules \
  "spring-boot-oauth2" \
  "spring-boot-oauth2-account" \
  "springdoc-mvc-openapi" \
  "springdoc-oauth2"

applyModules \
  "spring-boot-cucumber-mvc" \
  "spring-boot-cucumber-oauth2-authentication" \
  "kipe-expression" \
  "kipe-authorization" \
  "sample-feature"

npm i
npm run prettier:format
