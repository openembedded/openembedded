#!/bin/sh

MACHINE=`awk 'BEGIN { FS=": " } /Hardware/ { print $2 } ' </proc/cpuinfo`

case $MACHINE in
	"SHARP Shepherd" | "SHARP Husky" | "SHARP Corgi")
		xmodmap - < /etc/X11/shepherd.xmodmap
		;;
esac

if [ -z "`which chkhinge`" ]; then
   # probably not a clamshell zaurus
   exit 0
fi

chkhinge -e
if [ $? = 12 ]; then
   xrandr -o right
fi

