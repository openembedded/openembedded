DESCRIPTION = "ddccontrol - softwarewise change monitor settings"
LICENSE = "GPLv2"
HOMEPAGE = "http://sourceforge.net/projects/ddccontrol/"

PR = "r0"

inherit autotools

DEPENDS = "pciutils libxml2 gtk+ ddccontrol-db"

SRC_URI = "${SOURCEFORGE_MIRROR}/ddccontrol/ddccontrol-${PV}.tar.bz2"

FILES_${PN}+= "${datadir}/icons/Bluecurve/48x48/apps/gddccontrol.png"

SRC_URI[md5sum] = "b0eb367f3bc0564bd577e38d0b4107fc"
SRC_URI[sha256sum] = "986f3b4b27ec04e1da493de3aaab01cd5ea9566d7572c1a40b8d43cd7a491e84"
