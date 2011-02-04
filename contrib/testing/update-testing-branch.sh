#!/bin/sh

set -e

DATE=`date +%F`

cd /scratch/oe/oe-build/openembedded
git fetch
git checkout testing-next
git merge origin/master
git push oe-push HEAD
git branch tested_${DATE}

echo "master has been merged to testing-next and is ready for clean builds" | mail -s "testing branch ${DATE}" openembedded-devel@lists.openembedded.org -- -r "cliff.brake@gmail.com"

