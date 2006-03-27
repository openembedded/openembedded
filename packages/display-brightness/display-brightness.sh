#!/bin/sh

# display-brightness.sh
# simple script to set display-brightness for zaurus clamshell
# author: patrick steiner <patrick.steiner@a1.net>
# version: 1.00 | 22.02.2005 23:20


STEP=5
DRIVER="`ls /sys/class/backlight/|head -1`"
MAX_BRIGHTNESS=`cat /sys/class/backlight/$DRIVER/max_brightness`
ACTUAL_BRIGHTNESS=`cat /sys/class/backlight/$DRIVER/actual_brightness`
BRIGHTNESS_FILE="/sys/class/backlight/$DRIVER/brightness"

echo "max / current"
echo "$MAX_BRIGHTNESS / $ACTUAL_BRIGHTNESS"
if [ ! -n "$1" ]; then
    exit 0
fi

if [ "$1" = "up" ]; then
    if [ $ACTUAL_BRIGHTNESS -eq $MAX_BRIGHTNESS ]; then
        exit 0
    else
        let CURRENT_BRIGHTNESS=$ACTUAL_BRIGHTNESS+$STEP
        echo $CURRENT_BRIGHTNESS >> $BRIGHTNESS_FILE
        exit 0
    fi
fi

if [ "$1" = "down" ]; then
    if [ $ACTUAL_BRIGHTNESS -eq 0 ]; then
        exit 0
    elif [ $ACTUAL_BRIGHTNESS -lt $STEP ]; then
        STEP=1
        let CURRENT_BRIGHTNESS=$ACTUAL_BRIGHTNESS-$STEP
        echo $CURRENT_BRIGHTNESS >> $BRIGHTNESS_FILE
        exit 0
    else
        let CURRENT_BRIGHTNESS=$ACTUAL_BRIGHTNESS-$STEP
        echo $CURRENT_BRIGHTNESS >> $BRIGHTNESS_FILE
        exit 0
    fi
fi
