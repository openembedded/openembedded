SRC_URI = "ftp://sourceware.org/pub/libffi/${BPN}-${PV}.tar.gz"
LICENSE = "MIT"

SRC_URI[md5sum] = "1f300a7a7f975d4046f51c3022fa5ff1"
SRC_URI[sha256sum] = "589d25152318bc780cd8919b14670793f4971d9838dab46ed38c32b3ee92c452"

inherit autotools

do_install_append() {
	install -d ${D}${includedir}
	mv ${D}${libdir}/libffi-${PV}/include/* ${D}${includedir}/ || true
}

BBCLASSEXTEND = "native"

