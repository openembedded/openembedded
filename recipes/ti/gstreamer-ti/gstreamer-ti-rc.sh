#!/bin/sh
#
# configure kernel modules to run gst-ti plugins elements
#

load_module() {
    echo 
    echo -n "Running /usr/share/ti/gst/<platform>/loadmodule.sh"
    echo " (skipped)"
    # /usr/share/ti/gst/<platform>/loadmodule.sh
}

case "$1" in
      start) 
             echo -n "Loading kernel modules for gstreamer-ti... "
             load_module
             echo "  done"
             ;;
       stop) 
             echo "Nothing to do"
             ;;
        restart) 
             echo "Nothing to do"
             ;;
        *)
             echo "$0 <start/stop/restart>"
             ;;
esac

