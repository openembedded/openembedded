DESCRIPTION = "ddccontrol - softwarewise change monitor settings"
LICENSE = "GPLv2"
HOMEPAGE = "http://sourceforge.net/projects/ddccontrol/"

PR = "r0"

inherit autotools

DEPENDS = "pciutils libxml2 gtk+ ddccontrol-db"

SRC_URI = "${SOURCEFORGE_MIRROR}/ddccontrol/ddccontrol-${PV}.tar.bz2"

FILES_${PN}+= "${datadir}/icons/Bluecurve/48x48/apps/gddccontrol.png"
