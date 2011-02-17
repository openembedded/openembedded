require openssl.inc

inherit pkgconfig native

SRC_URI[src.md5sum] = "40b6ea380cc8a5bf9734c2f8bf7e701e"
SRC_URI[src.sha256sum] = "92511d1f0caaa298dba250426f8e7d5d00b271847886d1adc62422778d6320db"
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
