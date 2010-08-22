SECTION = "console/utils"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.uk.debian.org/debian/pool/main/s/sparc-utils/sparc-utils_1.9.orig.tar.gz"
SRC_URI[md5sum] = "08bf3f6d8433a1f4981a2afaa6b49a6c"
SRC_URI[sha256sum] = "b652bc27f95dcf10a7626b1d2943a1084e1e0b7f9bd3a97f9a46b6688370fe4b"

S = "${WORKDIR}/sparc-utils-1.9.orig/elftoaout-${PV}"

do_install() {
        install -d ${D}${bindir}
        install elftoaout ${D}${bindir}/
}

BBCLASSEXTEND = "native"

TARGET_CC_ARCH += "${LDFLAGS}"
NATIVE_INSTALL_WORKS = "1"
