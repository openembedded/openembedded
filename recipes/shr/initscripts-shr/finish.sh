#!/bin/sh

if ! test -e /etc/.configured; then
	opkg-cl configure
	> /etc/.configured
fi

