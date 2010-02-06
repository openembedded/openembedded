require iproute2.inc

PR = "${INC_PR}.1"
DATE = "070313"

SRC_URI_append = " file://new-flex-fix.patch;patch=1 \
                   file://ip6tunnel.patch;patch=1 \
                   file://man-pages-fix.patch;patch=1 \
                   file://remove-bashisms.patch;patch=1 \
                   file://no-strip.patch;patch=1"

S = "${WORKDIR}/iproute-${PV}-${DATE}"

