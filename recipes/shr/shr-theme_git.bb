DESCRIPTION = "Standard icon theme for the SHR distribution"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/data"
PV = "0.0.2+gitr${SRCREV}"
PR = "r2"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git/${PN}"

pkg_postinst_shr-theme () {
}

PACKAGE_ARCH = "all"

FILES_${PN} += "${datadir}/icons"
