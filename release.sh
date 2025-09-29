#!/bin/bash

GIT_MAIN_BRANCH='main'
GIT_REMOTE='upstream'

show_syntax() {
  echo "Usage: $0 <X.Y.Z>" >&2
  exit 1
}

if [ "$#" -ne 1 ]; then
  show_syntax
fi

version=$1

echo "*** Git: commit, tag and push tag..."
git add .
git commit -m "Release v${version}"
git tag -a v"${version}" -m "Release v${version}"

git push $GIT_REMOTE main
git push $GIT_REMOTE v"${version}"
