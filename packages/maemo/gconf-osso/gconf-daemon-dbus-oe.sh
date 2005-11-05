#!/bin/sh
# GConf daemon startup script for D-BUS activation
if [ -x /usr/sbin/dsmetool ]; then
  /usr/sbin/dsmetool -U messagebus -n -1 -t /usr/lib/gconf2/gconfd-2
else
  exec /usr/libexec/gconfd-2
fi
