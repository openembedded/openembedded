#!/bin/sh
FLAG=.ramdisk
echo "Content-type: text/html

<HTML> <HEAD> <TITLE>TOGGLING MAINTENANCE MODE</TITLE> </HEAD> <BODY> <H1>"
if [ -f /$FLAG ] ; then
   echo "REBOOTING IN NORMAL MODE"
   mkdir /mnt/maint
   mount -t jffs2 /dev/mtdblock4 /mnt/maint
   rm /mnt/maint/$FLAG
else
   echo "REBOOTING IN MAINTENANCE MODE"
   touch /$FLAG
fi
echo " </H1> </BODY> </HTML>"
echo

sleep 2

/usr/sbin/DO_Reboot
