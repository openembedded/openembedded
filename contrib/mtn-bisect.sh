#!/bin/bash

# the revision that we noticed does not longer build
LATEST_BAD_REV=$1

# an older revision that is known to build
LAST_KNOWN_GOOD_REV=$2

# count the number of commits 
COUNT=`mtn log --brief --no-merges --no-graph --to p:$LAST_KNOWN_GOOD_REV --from $LATEST_BAD_REV | tee /tmp/candidates.txt | wc -l`

echo $COUNT commits

# if COUNT == 1 stop

# make binary sections
COUNT=$(($(($COUNT + 1)) / 2))

CANDIDATE_REV=`cat /tmp/candidates.txt | head -n $COUNT | tail -n 1 | sed -e 's@\([a-f0-9]*\) .*@\1@'`

echo $CANDIDATE_REV

echo mtn up -r $CANDIDATE_REV
mtn up -r $CANDIDATE_REV


