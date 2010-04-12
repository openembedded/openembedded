DESCRIPTION = "hdparm is a Linux shell utility for viewing \
and manipulating various IDE drive and driver parameters."
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/hdparm/hdparm-${PV}.tar.gz "

do_install () {
	install -d ${D}/${base_sbindir} ${D}/${mandir}/man8
	oe_runmake 'DESTDIR=${D}' 'sbindir=${base_sbindir}' install
	mv ${D}${base_sbindir}/hdparm ${D}${base_sbindir}/hdparm.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${base_sbindir}/hdparm hdparm hdparm.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove hdparm hdparm.${PN}
}

SRC_URI[md5sum] = "0524dd10ad986285ff4eeb3507f7471c"
SRC_URI[sha256sum] = "689a413119c4d670ed95b9ac24511655c4805db678ad93866ab1036a0ba4d6bf"
