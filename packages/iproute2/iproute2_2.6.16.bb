PR = "r3"

DATE = "060323"

SRC_URI_append = " file://iproute2-2.6.15_no_strip.diff;patch=1;pnum=0 \
                   file://new-flex-fix.patch;patch=1"

S = "${WORKDIR}/iproute2-${PV}-${DATE}"

require iproute2.inc
