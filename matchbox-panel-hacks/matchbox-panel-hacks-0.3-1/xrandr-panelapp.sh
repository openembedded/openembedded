#!/bin/sh
if [ -n "$(xrandr | grep rotation | grep right)" ]
then 
xrandr -o normal
xmodmap /etc/X11/xmodmap-portrait
else 
xrandr -o right
xmodmap /etc/X11/xmodmap-right
fi
