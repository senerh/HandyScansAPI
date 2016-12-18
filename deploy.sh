#!/bin/bash
if [ "$TRAVIS_BRANCH" == "master" ]
then
  echo "Starting deployment"
  curl -p --insecure "ftp://$DEPLOY_HOST/$DEPLOY_REMOTEDIR/" --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" -T "$LOCAL_WAR" --ftp-create-dirs
else
  echo "The work is not deployed because the current branch is not master ($TRAVIS_BRANCH)."
fi