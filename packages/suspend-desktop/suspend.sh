#!/bin/sh
if [ -x /usr/bin/apm ]
then
	/usr/bin/apm --suspend
else
	if [ -x /usr/bin/pm ]
	then
		/usr/bin/pm -pp
	fi
fi
