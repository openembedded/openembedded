DESCRIPTION = "An arbitrary precision calculator language."
SECTION = "console/utils"
LICENSE = "GPLv2 LGPLv2.1"

PR = "r2"

SRC_URI = "${GNU_MIRROR}/bc/bc-${PV}.tar.gz \
           file://bc-1.06-fixes-1.patch"

SRC_URI[md5sum] = "d44b5dddebd8a7a7309aea6c36fda117"
SRC_URI[sha256sum] = "4ef6d9f17c3c0d92d8798e35666175ecd3d8efac4009d6457b5c99cea72c0e33"

inherit autotools

do_install () {
	autotools_do_install
	mv ${D}${bindir}/dc ${D}${bindir}/dc.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/dc dc dc.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove dc dc.${PN}
}

