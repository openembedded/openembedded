#!/bin/sh

case `uname -r` in
2.4*)
	TSLIB_TSDEVICE=/dev/ts
	TSLIB_TSEVENTTYPE=CORGI
	TSLIB_CONFFILE=/usr/share/tslib/ts.conf-corgi-2.4
	;;
*)
	for mouse in  usb.mouse unknown.mouse
	do
		test -e "/var/lib/udev-input-helper/$mouse" || continue
		. "/var/lib/udev-input-helper/$mouse"
		
		TSLIB_TSDEVICE="$DEVNAME"				
		
		# Used by /etc/X11/Xinit.d/70detect-stylus
		touch /var/lib/udev-input-helper/show-cursor.tslib
		
		# Note: Due to a bug in kdrive, setting TSLIB_TSDEVICE will
		# result in a non-working mouse, even if the device _is_ correct.
		# Currently, just unsetting this VAR will make kdrive use /dev/psaux
		# which works nicely for whatever reason ;)
		
		TSLIB_TSDEVICE=" "
		
		# Required on SL-Cxx00 due to fb rotation, might be needed elsewhere,
		# too.
		INPUT_EXTRA_ARGS="-rawcoord"
	done

	if test -z "$TSLIB_TSDEVICE"
	then
		TSLIB_TSDEVICE=/dev/input/event1
		rm -f /var/lib/udev-input-helper/show-cursor.tslib
	fi
	
	
	TSLIB_TSEVENTTYPE=INPUT
	TSLIB_CONFFILE=/usr/share/tslib/ts.conf-corgi
	;;
esac

export TSLIB_TSDEVICE TSLIB_TSEVENTTYPE TSLIB_CONFFILE INPUT_EXTRA_ARGS
