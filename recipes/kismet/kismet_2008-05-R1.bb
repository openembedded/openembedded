require kismet.inc

# patches *.diff are from openSUSE
SRC_URI += "file://kismet-2008-05-R1-crash.diff;patch=1;pnum=0 \
            file://kismet-2008-05-R1-fmt.diff;patch=1;pnum=0 \
            file://kismet-2008-05-R1-infinite-loop.diff;patch=1;pnum=0 \
            file://kismet-2008-05-R1-nonvoid.diff;patch=1;pnum=0 \
            file://fix_strip.patch;patch=1"

PR = "r0"
