DESCRIPTION = "Library for easy-accessing the 3d accelerometer LIS302DL from STMicroelectronics"
AUTHOR = "Michele Brocco <ssj2micvm@gmail.com>"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "glib-2.0"
RDEPENDS_${PN} = "glib-2.0"
RSUGGESTS_${PN} = ""
PV = "0.1+gitr${SRCPV}"
PR = "r1"

SRC_URI = "git://gitorious.org/sensor-monitor/liblis302dl.git;protocol=git;branch=master"

SRCREV = "b5f08fc1b2ad1f01bf868a04fc8335361a9be40c"
S = "${WORKDIR}/git"

inherit autotools vala

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

MAINTAINER = "Michele Brocco <ssj2micvm@gmail.com>"
