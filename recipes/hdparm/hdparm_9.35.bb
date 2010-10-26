DESCRIPTION = "hdparm is a Linux shell utility for viewing \
and manipulating various IDE drive and driver parameters."
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "BSD"

PACKAGES += "wiper"

FILES_wiper = "${bindir}/wiper.sh"
FILES_${PN} = "${base_sbindir} ${mandir}"

RDEPENDS_wiper = "bash gawk stat"

SRC_URI = "${SOURCEFORGE_MIRROR}/hdparm/hdparm-${PV}.tar.gz "
SRC_URI[md5sum] = "520996cc36b69212c3907df351296702"
SRC_URI[sha256sum] = "b778e5f42d918226892417986dc135e783e7a1b7b3986a4b1f637bcf51366f5f"

do_install () {
	install -d ${D}/${base_sbindir} ${D}/${mandir}/man8 ${D}/${bindir}
	oe_runmake 'DESTDIR=${D}' 'sbindir=${base_sbindir}' install
	mv ${D}${base_sbindir}/hdparm ${D}${base_sbindir}/hdparm.${PN}
	cp ${S}/wiper/wiper.sh ${D}/${bindir}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${base_sbindir}/hdparm hdparm hdparm.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove hdparm hdparm.${PN}
}
