#!/bin/sh
#
# configure kernel modules for TI DSP based gstreamer plugin
#
# Default Memory Map
#
# Start Addr    Size    Description
# -------------------------------------------
# 0x80000000    99 MB   Linux
# 0x86300000    16 MB   CMEM
# 0x87300000    13 MB   CODEC SERVER
# 

# Disable XDM 0.9 elements
export GST_TI_TIViddec_DISABLE=1
export GST_TI_TIAuddec_DISABLE=1
export GST_TI_TIVidenc_DISABLE=1
export GST_TI_TIImgdec_DISABLE=1
export GST_TI_TIImgenc_DISABLE=1

load_module() {
  #
  # CMEM Allocation
  #    1x5250000            Circular buffer
  #    6x829440,1x691200    Video buffers (max D1 PAL)
  #    1x345600             Underlying software components (codecs, etc.)
  #    1x1                  Dummy buffer used during final flush
  modprobe cmemk allowOverlap=1 phys_start=0x86300000 phys_end=0x87300000 \
        pools=1x5250000,6x829440,1x345600,1x691200,1x1

  # insert DSP/BIOS Link driver
  modprobe dsplinkk

  # insert Local Power Manager driver
  modprobe lpm_omap3530

  # insert SDMA driver
  modprobe sdmak 
}

unload_module() {
   rmmod cmemk
   rmmod lpm_omap3530
   rmmod dsplinkk
   rmmod sdmak
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

