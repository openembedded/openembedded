PR = "r0"

DATE = "070710"

SRC_URI_append = " file://new-flex-fix.patch;patch=1 \
                   file://no-strip.patch;patch=1"

S = "${WORKDIR}"

require iproute2.inc
