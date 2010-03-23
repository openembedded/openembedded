require acpid.inc

SRC_URI_append = " file://event.c.diff;patch=1 \
                   file://netlink.diff;patch=1 \
                   file://gcc44.diff;patch=1 \
                 "
PR = "${INC_PR}.0"