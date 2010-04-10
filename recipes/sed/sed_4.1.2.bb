LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "sed is a Stream EDitor."
PR = "r1"

SRC_URI = "${GNU_MIRROR}/sed/sed-${PV}.tar.gz"
S = "${WORKDIR}/sed-${PV}"

inherit autotools

do_install () {
	autotools_do_install
	install -d ${D}${base_bindir}
	mv ${D}${bindir}/sed ${D}${base_bindir}/sed.${PN}
}


pkg_postinst_${PN} () {
	update-alternatives --install ${base_bindir}/sed sed sed.${PN} 100
}


pkg_prerm_${PN} () {
	update-alternatives --remove sed sed.${PN}
}


SRC_URI[md5sum] = "928f0e06422f414091917401f1a834d0"
SRC_URI[sha256sum] = "638e837ba765d5da0a30c98b57c2953cecea96827882f594612acace93ceeeab"
