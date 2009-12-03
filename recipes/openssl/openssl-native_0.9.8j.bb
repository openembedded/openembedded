inherit pkgconfig native

require openssl.inc

PR = "${INC_PR}.1"

# This flag can contain target options (e.g -mfpu=neon for armv7-a systems)
export FULL_OPTIMIZATION = " "
export BUILD_OPTIMIZATION = " "

SRC_URI += "file://configure-targets.patch;patch=1 \
            file://shared-libs.patch;patch=1 \
            file://debian.patch;patch=1"

PARALLEL_MAKE = ""

CFLAG += " -Wa,--noexecstack "

do_install() {
	:
}

