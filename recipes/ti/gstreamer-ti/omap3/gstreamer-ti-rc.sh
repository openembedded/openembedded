#!/bin/sh
#
# configure kernel modules to run gst-ti plugins elements
#

load_module() {
    echo 
    echo -n "Running /usr/share/ti/gst/omap3530/loadmodule.sh"
    sh /usr/share/ti/gst/omap3530/loadmodule.sh
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

