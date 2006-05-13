#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: playbeep.sh
# Date: 12-Apr-06

if test -x /usr/sbin/alsactl -a -e /etc/modules -a "$ENABLE_SOUND" = yes
then
	for module in `cat /etc/modules | grep snd | grep -v ^#` 
	do
		#echo "loading $module"
		modprobe $module
	done

	mount -o remount,rw /
	
	init_rootfs >/dev/null 2>&1

	! test -e /dev/audio && mknod /dev/audio c 14 4
	! test -e /dev/dsp && mknod /dev/dsp c 14 3
		
	mkdir /dev/snd >/dev/null 2>&1
	mknod /dev/snd/controlC0 c 116 0 >/dev/null 2>&1
	mknod /dev/snd/pcmC0D0c c 116 24 >/dev/null 2>&1
	mknod /dev/snd/pcmC0D0p c 116 16 >/dev/null 2>&1
	mknod /dev/snd/timer c 116 33 >/dev/null 2>&1
	/usr/sbin/alsactl restore >/dev/null 2>&1
	
	test -e /usr/share/sounds/beep.raw && cat /usr/share/sounds/beep.raw > /dev/dsp  
fi

/bin/true
