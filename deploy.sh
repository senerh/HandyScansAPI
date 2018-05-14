#!/bin/bash
if [ "$TRAVIS_BRANCH" == "master" -a "$TRAVIS_PULL_REQUEST" = "false" ]
then
  echo "Starting PROD deployment..."
  mv target/shonen-touch-api.war target/shonen-touch-api-3.war
  curl -p --insecure "ftp://$DEPLOY_HOST/$DEPLOY_REMOTEDIR/" --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" -T "target/shonen-touch-api-3.war" --ftp-create-dirs
elif [ "$TRAVIS_BRANCH" == "develop" ]
then
  echo "Starting DEV deployment..."
  mv target/shonen-touch-api.war target/shonen-touch-api-dev.war
  curl -p --insecure "ftp://$DEPLOY_HOST/$DEPLOY_REMOTEDIR/" --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" -T "target/shonen-touch-api-dev.war" --ftp-create-dirs
else
  echo "No deployment for branch: $TRAVIS_BRANCH."
fi