#!/bin/sh

/usr/bin/showiframe /boot/backdrop.mvi

init=0
/usr/bin/boot || init=1
if [ $init -eq 1 ] ; then
	rm -R /etc/enigma
fi

if [ ! -e /etc/enigma ] ; then
	cp -R /usr/share/enigma/default /etc/enigma
fi

/usr/bin/enigma

ret=$?
case $ret in
	0)
		/sbin/halt
		;;
	4)
		/sbin/reboot
		;;
	*)
		;;
esac

