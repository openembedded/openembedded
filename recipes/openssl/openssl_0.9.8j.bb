inherit pkgconfig

require openssl.inc

PR = "${INC_PR}.0"

export OE_LDFLAGS="${LDFLAGS}"

SRC_URI += "file://configure-targets.patch;patch=1 \
            file://shared-libs.patch;patch=1 \
            file://debian.patch;patch=1 \
            file://oe-ldflags.patch;patch=1"

PARALLEL_MAKE = ""
