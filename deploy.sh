#!/bin/bash
if [ "$TRAVIS_BRANCH" == "master" ]; then
  curl -p --insecure "ftp://$DEPLOY_HOST/$DEPLOY_REMOTEDIR/" --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" -T "$LOCAL_WAR" --ftp-create-dirs
fi