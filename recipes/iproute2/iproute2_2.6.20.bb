require iproute2.inc

PR = "${INC_PR}.1"
DATE = "070313"

SRC_URI_append = " file://new-flex-fix.patch;apply=yes \
                   file://ip6tunnel.patch;apply=yes \
                   file://man-pages-fix.patch;apply=yes \
                   file://remove-bashisms.patch;apply=yes \
                   file://no-strip.patch;apply=yes"

S = "${WORKDIR}/iproute-${PV}-${DATE}"


SRC_URI[md5sum] = "7bc5883aadf740761fa2dd70b661e8cc"
SRC_URI[sha256sum] = "3b3960f867bf878a6561428a3c572e87dcccadb7123aa47d7aaca77b32adecc8"
