#!/bin/sh
#
# bootclean.sh - Cleans out /tmp, /var/run, and /var/lock
# This script should run after mountall.sh in runlevel S.
#
# This script relies upon find and xargs, and is largely
# based on the equivalent script in the Debian releases.

. /etc/default/rcS

# Completely clean out everything in /tmp, but do not walk into
# anything that might be mounted beneath /tmp.  If /tmp is not
# a directory, ignore this (it's probably a symlink to
# /var/volatiles/tmp, and we best leave it alone).

if [ -d /tmp -a ! -L /tmp ] ; then
  echo "bootclean.sh: Cleaning /tmp..."
  cd /tmp || { echo "bootclean.sh: unable to cd to /tmp." ; return 1 ; }
  find . -depth -xdev ! -type d -print0 | xargs -0r rm -f --
  find . -depth -xdev -type d ! -name . -empty -exec rmdir \{\} \;
else
  echo "bootclean.sh: Skipping /tmp (not a directory)..."
fi

# Now clean out /var/lock.

if [ -d /var/lock -a ! -L /var/lock ] ; then
  echo "bootclean.sh: Cleaning /var/lock..."
  cd /var/lock || { echo "bootclean.sh: unable to cd to /var/lock." ; return 1 ; }
  find . -xdev ! -type d -print0 | xargs -0r rm -f --
else
  echo "bootclean.sh: Skipping /var/lock (not a directory)..."
fi

# Now clean out /var/run.

if [ -d /var/run -a ! -L /var/run ] ; then
  echo "bootclean.sh: Cleaning /var/run..."
  cd /var/run || { echo "bootclean.sh: unable to cd to /var/run." ; return 1 ; }
  find . -xdev ! -type d ! -name utmp -print0 | xargs -0r rm -f --
else
  echo "bootclean.sh: Skipping /var/run (not a directory)..."
fi

# done.

exit 0
