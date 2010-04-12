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
    # insert cmem
    modprobe cmemk phys_start=0x85400000 phys_end=0x88000000 \
        pools=1x6651904,1x3670016,18x1548288,1x282624,1x159744,1x49152,1x32768,1x28672,1x16384,3x12288,2x8192,36x4096

    modprobe irqk
    modprobe edmak
    modprobe dm365mmap
    rm -f /dev/dm365mmap
    mknod /dev/dm365mmap c `awk "\\$2==\"dm365mmap\" {print \\$1}" /proc/devices` 0
}

unload_module() {
   rmmod cmemk 2>/dev/null
   rmmod irqk 2>/dev/null
   rmmod edmak 2>/dev/null
   rmmod dm365mmap 2>/dev/null
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
