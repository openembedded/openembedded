inherit pkgconfig

require openssl.inc

PR = "r1"

SRC_URI += "file://configure-targets.patch;patch=1 \
            file://shared-libs.patch;patch=1 \
            file://debian.patch;patch=1"

PARALLEL_MAKE = ""
