#!/bin/sh

TSLIB_TSDEVICE=`detect-stylus --device`
TSLIB_CONFFILE=/etc/ts.conf

# this one is for making opie happy...
QWS_MOUSE_PROTO=TPanel:`detect-stylus --device`
export TSLIB_TSDEVICE TSLIB_CONFFILE QWS_MOUSE_PROTO

