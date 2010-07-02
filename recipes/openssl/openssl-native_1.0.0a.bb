require openssl.inc

inherit pkgconfig native

SRC_URI[src.md5sum] = "e3873edfffc783624cfbdb65e2249cbd"
SRC_URI[src.sha256sum] = "18a9bd1fc02b8ef90dded34fafaa9089baaafef278a19fc4e89c2ab0dcf70f63"
PR = "${INC_PR}.0"

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
