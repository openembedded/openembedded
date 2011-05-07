DESCRIPTION = "Standard icon theme for the SHR distribution"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=297cd7a08a1ae4d946a1164f25bacd88"
SECTION = "x11/data"

SRCREV = "730da87ad75c814c16c856ca138605d985b6efdb"
PV = "0.0.2+gitr${SRCPV}"
PR = "r2"

inherit autotools gettext

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git/${PN}"

pkg_postinst_shr-theme () {
}

PACKAGE_ARCH = "all"

FILES_${PN} += "${datadir}/icons"
