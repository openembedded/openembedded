inherit pkgconfig

require openssl.inc
SRC_URI[src.md5sum] = "898bf125370926d5f692a2201124f8ec"
SRC_URI[src.sha256sum] = "36037160281cf4977d964e403d2bc0680fbca0a7ff9f65e33136d75fae12cb5b"

PR = "${INC_PR}.0"

export OE_LDFLAGS="${LDFLAGS}"

SRC_URI += "file://configure-targets.patch;patch=1 \
            file://shared-libs.patch;patch=1 \
            file://debian.patch;patch=1 \
            file://oe-ldflags.patch;patch=1"

PARALLEL_MAKE = ""
