DESCRIPTION = "GNU cpio is a program to manage archives of files."
HOMEPAGE = "http://www.gnu.org/software/cpio/"
SECTION = "console"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PR = "r3"

SRC_URI = "${GNU_MIRROR}/cpio/cpio-${PV}.tar.gz \
	   file://install.patch;patch=1"
S = "${WORKDIR}/cpio-${PV}"

inherit autotools

do_install () {
	autotools_do_install
	mv ${D}${libexecdir}/rmt ${D}${libexecdir}/rmt.${PN}
}


pkg_postinst_${PN} () {
	update-alternatives --install ${libexecdir}/rmt rmt rmt.${PN} 50
}


pkg_prerm_${PN} () {
	update-alternatives --remove rmt rmt.${PN}
}

