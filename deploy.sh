#!/bin/bash
if [ "$TRAVIS_BRANCH" == "master" ]
then
  echo "Starting deployment on production"
  mv target/shonen-touch-api.war target/shonen-touch-api-3-0-0.war
  curl -p --insecure "ftp://$DEPLOY_HOST/$DEPLOY_REMOTEDIR/" --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" -T "target/shonen-touch-api-3-0-0.war" --ftp-create-dirs
elif [ "$TRAVIS_BRANCH" == "develop" ]
then
  echo "Starting deployment on integration"
  mv target/shonen-touch-api.war target/shonen-touch-api-dev.war
  curl -p --insecure "ftp://$DEPLOY_HOST/$DEPLOY_REMOTEDIR/" --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" -T "target/shonen-touch-api-dev.war" --ftp-create-dirs
else
  echo "Starting branch deployment ($TRAVIS_BRANCH)"
  mv target/shonen-touch-api.war target/shonen-touch-api-branch.war
  curl -p --insecure "ftp://$DEPLOY_HOST/$DEPLOY_REMOTEDIR/" --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" -T "target/shonen-touch-api-branch.war" --ftp-create-dirs
fi