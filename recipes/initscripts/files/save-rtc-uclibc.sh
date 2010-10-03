#! /bin/sh
/etc/init.d/hwclock.sh stop

# Update the timestamp
date +%m%d%H%M%Y > /etc/timestamp
