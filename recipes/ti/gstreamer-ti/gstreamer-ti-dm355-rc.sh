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
    # CMEM Allocation
    #    1x3628800 Circular buffer
    #    4x829440  Video buffers (max D1 PAL)
    #    1x829440  Underlying software components (codecs, etc.)
    #    1x518400  Underlying software components (codecs, etc.)
    #    1x4948    Underlying software components (codecs, etc.)
    #    1x1505280 Underlying software components (codecs, etc.)
    #    1x5760    Underlying software components (codecs, etc.)
    #    1x8192    Underlying software components (codecs, etc.)
    #    1x1       Dummy buffer used during final flush
    modprobe cmemk phys_start=0x87400000 phys_end=0x88000000 \
        pools=1x3628800,5x829440,1x518400,1x4948,1x1505280,1x5760,1x8192,1x1

    modprobe dm350mmap
    rm -f /dev/dm350mmap
    mknod /dev/dm350mmap c `awk "\\$2==\"dm350mmap\" {print \\$1}" /proc/devices` 0

}

unload_module() {
   rmmod cmemk
   rmmod dm350mmap
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

