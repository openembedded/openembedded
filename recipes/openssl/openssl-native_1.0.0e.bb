require openssl.inc

inherit pkgconfig native

SRC_URI[src.md5sum] = "7040b89c4c58c7a1016c0dfa6e821c86"
SRC_URI[src.sha256sum] = "e361dc2775733fb84de7b5bf7b504778b772869e8f7bfac0b28b935cbf7380f7"
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

export DIRS = "crypto ssl apps engines"

# This flag can contain target options (e.g -mfpu=neon for armv7-a systems)
export FULL_OPTIMIZATION = " "
export BUILD_OPTIMIZATION = " "

SRC_URI += "file://configure-targets.patch \
            file://shared-libs.patch \
            file://oe-ldflags.patch \
            file://engines-install-in-libdir-ssl.patch \
            file://openssl-fix-link.patch \
            file://debian/version-script.patch \
            file://debian/pic.patch \
            file://debian/c_rehash-compat.patch \
            file://debian/ca.patch \
            file://debian/make-targets.patch \
            file://debian/no-rpath.patch \
            file://debian/man-dir.patch \
            file://debian/man-section.patch \
            file://debian/pkg-config.patch \
            file://debian/no-symbolic.patch \
            file://debian/debian-targets.patch \
           "

PARALLEL_MAKE = ""

CFLAG += " -Wa,--noexecstack "

NATIVE_INSTALL_WORKS = "1"
