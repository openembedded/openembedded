#!/bin/sh

TSLIB_TSDEVICE=`detect-tsdevice`
TSLIB_CONFFILE=/usr/share/tslib/ts.conf-h3600

export TSLIB_TSDEVICE TSLIB_CONFFILE
