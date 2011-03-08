SRC_URI = "ftp://sourceware.org/pub/libffi/${BPN}-${PV}.tar.gz"
LICENSE = "MIT"

inherit autotools

do_install_append() {
	install -d ${D}${includedir}
	mv ${D}${libdir}/libffi-${PV}/include/* ${D}${includedir}/ || true
}

BBCLASSEXTEND = "native"

