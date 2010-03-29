require openssl.inc

inherit pkgconfig native

SRC_URI[src.md5sum] = "898bf125370926d5f692a2201124f8ec"
SRC_URI[src.sha256sum] = "36037160281cf4977d964e403d2bc0680fbca0a7ff9f65e33136d75fae12cb5b"
PR = "${INC_PR}.2"

# This flag can contain target options (e.g -mfpu=neon for armv7-a systems)
export FULL_OPTIMIZATION = " "
export BUILD_OPTIMIZATION = " "

SRC_URI += "file://configure-targets.patch;patch=1 \
            file://shared-libs.patch;patch=1 \
            file://debian.patch;patch=1"

PARALLEL_MAKE = ""

CFLAG += " -Wa,--noexecstack "

NATIVE_INSTALL_WORKS = "1"
