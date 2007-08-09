PR = "r2"

SRC_URI_append = " file://new-flex-fix.patch;patch=1 \
                   file://ip6tunnel.patch;patch=1 \
                   file://man-pages-fix.patch;patch=1 \
                   file://no-strip.patch;patch=1"

require iproute2.inc

DIRNAME = "iproute"
DATE = "070313"
