require openssl.inc

inherit pkgconfig native

SRC_URI[src.md5sum] = "104deb3b7e6820cae6de3f49ba0ff2b0"
SRC_URI[src.sha256sum] = "4e7b4e2fb33ee2d97c5e143561ab495dbbfc08f0a863e617a0c7adca19017331"
PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"

export DIRS = "crypto ssl apps engines"

# This flag can contain target options (e.g -mfpu=neon for armv7-a systems)
export FULL_OPTIMIZATION = " "
export BUILD_OPTIMIZATION = " "

SRC_URI += "file://configure-targets.patch \
            file://shared-libs.patch \
            file://debian.patch \
	    file://libdeps-first.patch \
	   "

PARALLEL_MAKE = ""

CFLAG += " -Wa,--noexecstack "

NATIVE_INSTALL_WORKS = "1"
