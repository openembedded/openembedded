#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: input.sh
# Date: 07-May-06

TMP_DIR="/var/lib/udev-input-helper"

mkdir -p "$TMP_DIR"

get_type() {
	case "$DEVNAME" in
	*mouse*)	DEVTYPE=mouse;;
	esac
	
	case "$PHYSDEVBUS" in
	*usb*)		DEVBUS=usb;;
	esac
}

add_input() {		
	if test -n "$DEVTYPE" -a -n "$DEVBUS"
	then
		echo "DEVNAME=\"$DEVNAME\"" > "$TMP_DIR/$DEVBUS.$DEVTYPE"
	fi
}

remove_input(){
	if test -n "$DEVTYPE" -a -n "$DEVBUS"
	then
		rm -f "$TMP_DIR/$DEVBUS.$DEVTYPE"
	fi
}

get_type

case "$ACTION" in 
add)	add_input;;
remove)	remove_input;;
esac
