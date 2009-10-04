require dietlibc.inc

PR = "${INC_PR}.2"

SRC_URI += "file://ccache.patch;patch=1 \
            file://ceil.patch;patch=1 \
            file://diethome.patch;patch=1 \
            file://getrlimit.patch;patch=1 \
           " 

