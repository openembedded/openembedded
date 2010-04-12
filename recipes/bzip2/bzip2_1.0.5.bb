DESCRIPTION = "Very high-quality data compression program"
SECTION = "console/utils"
PR = "r2"

LICENSE = "bzip2"
SRC_URI = "http://www.bzip.org/${PV}/bzip2-${PV}.tar.gz \
	   file://bzip2-1.0.5-autoconfiscated.patch;patch=1"

inherit autotools pkgconfig

do_configure_prepend () {
	if test -f LICENSE ; then sh ./autogen.sh ; fi
}

do_install_append () {
	mv ${D}${bindir}/bunzip2 ${D}${bindir}/bunzip2.${PN}
	mv ${D}${bindir}/bzcat ${D}${bindir}/bzcat.${PN}
	ln -sf libbz2.so.1.0.5 ${D}${libdir}/libbz2.so.1.0
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

SRC_URI[md5sum] = "3c15a0c8d1d3ee1c46a1634d00617b1a"
SRC_URI[sha256sum] = "f7bf5368309d76e5daf3a89d4d1bea688dac7780742e7a0ae1af19be9316fe22"
