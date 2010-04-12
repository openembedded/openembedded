#!/bin/sh
#
# configure kernel modules for TI DSP based gstreamer plugin
#

# Disable XDM 0.9 elements
export GST_TI_TIViddec_DISABLE=1
export GST_TI_TIAuddec_DISABLE=1
export GST_TI_TIVidenc_DISABLE=1
export GST_TI_TIImgdec_DISABLE=1
export GST_TI_TIImgenc_DISABLE=1

load_module() {
    # insert cmemk, tell it to occupy physical 34MB-64MB.
    #
    modprobe cmemk phys_start=0xC2200000 phys_end=0xC3200000 \
        pools=1x5250000,3x1048576,3x829440,1x256000,4x131072

    modprobe dsplinkk

    rm -f /dev/dsplink
    mknod /dev/dsplink c `awk "\\$2==\"dsplink\" {print \\$1}" /proc/devices` 0
}

unload_module() {
   rmmod cmemk
   rmmod dsplinkk
   rm -f /dev/dsplink
}

case "$1" in
      start) 
             echo -n "Loading kernel modules for gstreamer-ti... "
             load_module
             echo "  done"
             ;;
       stop) 
             echo -n "Unloading kernel module ..."
             unload_module
             echo "   done"
             ;;
        restart) 
             echo -n "Unloading kernel module ..."
             unload_module
             echo "   done"
             echo -n "Loading kernel modules for gstreamer-ti... "
             load_module
             echo "  done"
             ;;
        *)
             echo "$0 <start/stop/restart>"
             ;;
esac

