DESCRIPTION = "hdparm is a Linux shell utility for viewing \
and manipulating various IDE drive and driver parameters."
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "BSD"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/hdparm/hdparm-${PV}.tar.gz \
	   file://bswap.patch;patch=1 \
	   file://uclibc.patch;patch=1"

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
SRC_URI[md5sum] = "62749c6cdf28ce31aae335092fa107df"
SRC_URI[sha256sum] = "cae6ed86296d01be98ee3be0c224c4323eee508941a7f162a0366d56655afe06"
