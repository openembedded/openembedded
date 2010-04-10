inherit pkgconfig native

require openssl.inc

PR = "${INC_PR}.0"

# This flag can contain target options (e.g -mfpu=neon for armv7-a systems)
export FULL_OPTIMIZATION = " "
export BUILD_OPTIMIZATION = " "

SRC_URI += "file://debian.patch;patch=1 \
            file://configure-targets.patch;patch=1 \
            file://shared-libs.patch;patch=1"

PARALLEL_MAKE = ""

do_install() {
	:
}

PACKAGES = ""

SRC_URI[src.md5sum] = "acf70a16359bf3658bdfb74bda1c4419"
SRC_URI[src.sha256sum] = "0e26886845de95716c9f1b9b75c0e06e9d4075d2bdc9e11504eaa5f7ee901cf0"
