DESCRIPTION = "Very high-quality data compression program"
SECTION = "console/utils"
PR = "r0"

LICENSE = "bzip2"
SRC_URI = "http://www.bzip.org/${PV}/bzip2-${PV}.tar.gz \
	   file://bzip2-1.0.5-autoconfiscated.patch"
SRC_URI[md5sum] = "00b516f4704d4a7cb50a1d97e6e8e15b"
SRC_URI[sha256sum] = "a2848f34fcd5d6cf47def00461fcb528a0484d8edef8208d6d2e2909dc61d9cd"

inherit autotools pkgconfig

do_configure_prepend () {
	if test -f LICENSE ; then sh ./autogen.sh ; fi
}

do_install_append () {
	mv ${D}${bindir}/bunzip2 ${D}${bindir}/bunzip2.${PN}
	mv ${D}${bindir}/bzcat ${D}${bindir}/bzcat.${PN}
	ln -sf libbz2.so.${PV} ${D}${libdir}/libbz2.so.1.0
}

PACKAGES =+ "libbz2"
FILES_libbz2 = "${libdir}/libbz2.so.*"

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/bunzip2 bunzip2 bunzip2.${PN} 100
	update-alternatives --install ${bindir}/bzcat bzcat bzcat.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove bunzip2 bunzip2.${PN}
	update-alternatives --remove bzcat bzcat.${PN}
}
