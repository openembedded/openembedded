require iproute2.inc

PR = "${INC_PR}.1"
DATE = "070313"

SRC_URI_append = " file://new-flex-fix.patch;patch=1 \
                   file://ip6tunnel.patch;patch=1 \
                   file://man-pages-fix.patch;patch=1 \
                   file://remove-bashisms.patch;patch=1 \
                   file://no-strip.patch;patch=1"

S = "${WORKDIR}/iproute-${PV}-${DATE}"


SRC_URI[md5sum] = "7bc5883aadf740761fa2dd70b661e8cc"
SRC_URI[sha256sum] = "3b3960f867bf878a6561428a3c572e87dcccadb7123aa47d7aaca77b32adecc8"
