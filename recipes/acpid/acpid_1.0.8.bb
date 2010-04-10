require acpid.inc

SRC_URI_append = " file://event.c.diff;patch=1 \
                   file://fixfd.diff;patch=1 \
                   file://netlink.diff;patch=1"
PR = "${INC_PR}.0"
SRC_URI[md5sum] = "1d9c52fe2c0b51f8463f357c2a3d3ddb"
SRC_URI[sha256sum] = "d57ae5302c38c37d060a097fa51600fe06fbfffd575641d638407944f126b7b1"
