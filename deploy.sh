#!/bin/bash
if [ "$TRAVIS_BRANCH" == "master" ]
then
  echo "Starting deployment on production"
  curl -p --insecure "ftp://$DEPLOY_HOST/$DEPLOY_REMOTEDIR/" --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" -T "target/shonen-touch-api.war" --ftp-create-dirs
elif [ "$TRAVIS_BRANCH" == "develop" ]
then
  echo "Starting deployment on integration"
  mv target/shonen-touch-api.war target/shonen-touch-api-dev.war
  curl -p --insecure "ftp://$DEPLOY_HOST/$DEPLOY_REMOTEDIR/" --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" -T "target/shonen-touch-api-dev.war" --ftp-create-dirs
else
  echo "The work is not deployed because the current branch is neither master nor develop ($TRAVIS_BRANCH)."
fi