SECTION = "base"
DESCRIPTION = "GNU tar saves many files together into a single tape \
or disk archive, and can restore individual files from the archive."
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PR = "r1"

SRC_URI = "ftp://alpha.gnu.org/gnu/tar/tar-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://m4.patch;patch=1"

inherit autotools

do_install () {
	autotools_do_install
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
