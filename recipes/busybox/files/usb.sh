#!/bin/sh

case "$ACTION" in
  add|"")
    for uevent in /sys/class/usb_device/usbdev?.*/*/uevent; do
      . $uevent
      if [ ! -e /dev/bus/usb/$BUSNUM/$DEVNUM ]; then
        mkdir -p /dev/bus/usb/$BUSNUM
        mknod /dev/bus/usb/$BUSNUM/$DEVNUM c 189 $MINOR
      fi
    done
    ;;
  remove)
    for device in /dev/bus/usb/*/*; do
      REMOVED=1
      dev=`basename $device`
      bus=`basename $(dirname $device)`
      for uevent in /sys/class/usb_device/usbdev?.*/*/uevent; do
        . $uevent
        if [ $dev -eq $DEVNUM ] && [ $bus -eq $BUSNUM ]; then
          REMOVED=0
          break;
        fi
      done
      if [ $REMOVED -eq 1 ]; then
        rm /dev/bus/usb/$bus/$dev
        if [ -z $(ls /dev/bus/usb/$bus/) ]; then
          rmdir /dev/bus/usb/$bus/
        fi
      fi
    done
    ;;
esac
