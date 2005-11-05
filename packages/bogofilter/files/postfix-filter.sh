#!/bin/sh

FILTER=/usr/bin/bogofilter
FILTER_DIR=/var/spool/filter
POSTFIX=/usr/sbin/sendmail
export BOGOFILTER_DIR=/home/bogo

# Exit codes from <sysexits.h>
EX_TEMPFAIL=75
EX_UNAVAILABLE=69

cd $FILTER_DIR || { echo $FILTER_DIR does not exist; exit $EX_TEMPFAIL; }

# Clean up when done or when aborting.
trap "rm -f msg.$$ ; exit $EX_TEMPFAIL" 0 1 2 3 15

# bogofilter -e returns: 0 for OK, nonzero for error
rm -f msg.$$ || exit $EX_TEMPFAIL
$FILTER -p -u -e > msg.$$ || exit $EX_TEMPFAIL

exec <msg.$$ || exit $EX_TEMPFAIL
rm -f msg.$$ # safe, we hold the file descriptor
exec $POSTFIX "$@"
exit $EX_TEMPFAIL

