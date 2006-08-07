#!/bin/sh

if (uname -r|grep -q 'embedix'); then
	TSLIB_TSDEVICE=/dev/ts
	TSLIB_TSEVENTTYPE=COLLIE
	TSLIB_CONFFILE=/usr/share/tslib/ts-2.4.conf
else
	TSLIB_TSDEVICE=/dev/input/event1
	TSLIB_CONFFILE=/usr/share/tslib/ts-2.6.conf
fi

export TSLIB_TSDEVICE TSLIB_TSEVENTTYPE TSLIB_CONFFILE
