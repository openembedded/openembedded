#!/bin/sh

if (uname -r|grep -q 'embedix'); then
	TSLIB_TSDEVICE=/dev/ts
	TSLIB_TSEVENTTYPE=COLLIE
else
	TSLIB_TSDEVICE=/dev/input/event1
fi

TSLIB_CONFFILE=/usr/share/tslib/ts.conf

export TSLIB_TSDEVICE TSLIB_TSEVENTTYPE TSLIB_CONFFILE
