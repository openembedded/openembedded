inherit pkgconfig

require openssl.inc

PR = "r6"

SRC_URI += "file://debian.patch;patch=1 \
            file://configure-targets.patch;patch=1"

PARALLEL_MAKE = ""
