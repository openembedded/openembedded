#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: setDPI.sh
# Date: 09-Apr-06

# This script configures Xft.dpi dependent on your screens DPI. This insures that the same font-size
# setting of 7 can be used on all machines.


XDEFAULTS="/etc/X11/Xdefaults"



set_dpi() {
	
	CURRENT_SETTING="`cat /etc/X11/Xdefaults | sed -n "/Xft.dpi\:/s/.*\:\(.*\)/\1/p" | sed -n "s/\ //p"`"	

	if test "$CURRENT_SETTING" != "$1"
	then
		echo "Using Xft.dpi of $SET_SCREEN_DPI for your $SCREEN_DPI DPI screen"
		
		if grep -q "Xft.dpi" "$XDEFAULTS"
		then
			cat "${XDEFAULTS}" | sed "s/^Xft.dpi\:.*/Xft.dpi\: $SET_SCREEN_DPI/" > "${XDEFAULTS}_"
			mv "${XDEFAULTS}_" "${XDEFAULTS}"
		else
			echo -e "Xft.dpi: $SET_SCREEN_DPI\n" >> "$XDEFAULTS"
		fi
	else
		echo "Your $SCREEN_DPI DPI screen is already configured."
	fi
}

if test -z "$DISPLAY"
then
	echo "DISPLAY is not set, aborting..."
	exit 0
fi

SCREEN_DPI="`/usr/bin/xdpyinfo | grep "dots per inch" | awk '{print $2}'| sed -n "s/\(.*\)x\(.*\)/\2/p"`"

if test -z "$SCREEN_DPI"
then
	echo "WARNING: Couldn't read your screens DPI, defaulting to 100"
	SCREEN_DPI=100
fi

# Configure your screen here:
test "$SCREEN_DPI" -gt 180 -a "$SCREEN_DPI" -lt "221" && SET_SCREEN_DPI=160
test "$SCREEN_DPI" -gt 90 -a "$SCREEN_DPI" -lt "121" && SET_SCREEN_DPI=100


if test -z "$SET_SCREEN_DPI"
then
	echo "WARNING: No default configuration found for your $SCREEN_DPI DPI screen!"
	echo "Using 100 DPI"
	SET_SCREEN_DPI=100
fi

set_dpi "$SET_SCREEN_DPI"
