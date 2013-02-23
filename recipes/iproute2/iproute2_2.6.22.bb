require iproute2.inc
SRC_URI = "http://www.the-little-red-haired-girl.org/pub/nylon/thirdparty/${P}-${DATE}.tar.gz"

PR = "r1"
DATE = "070710"

SRC_URI_append = " file://new-flex-fix.patch;patch=1 \
                   file://ip6tunnel.patch;patch=1 \
                   file://no-strip.patch;patch=1"

S = "${WORKDIR}"

