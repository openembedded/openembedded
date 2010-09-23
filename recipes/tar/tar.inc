DESCRIPTION = "GNU tar saves many files together into a single tape \
or disk archive, and can restore individual files from the archive."
SECTION = "base"
LICENSE = "GPLv3"
INC_PR = "r1"
BBCLASSEXTEND = "native"

SRC_URI = "${GNU_MIRROR}/tar/tar-${PV}.tar.bz2"

inherit autotools gettext

# We only want rename for update-alternatives on the target
do_install_append_pn-tar () {
	install -d ${D}${base_bindir}
	mv ${D}${bindir}/tar ${D}${base_bindir}/tar.${PN}
	mv ${D}${libexecdir}/rmt ${D}${libexecdir}/rmt.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${base_bindir}/tar tar tar.${PN} 100
	update-alternatives --install ${libexecdir}/rmt rmt rmt.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove tar tar.${PN}
	update-alternatives --remove rmt rmt.${PN}
}
