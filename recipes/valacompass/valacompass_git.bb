DESCRIPTION = "Compass written in vala that uses the hmc5843 compass and the lis302dl accelerometer"
AUTHOR = "Michele Brocco <ssj2micvm@gmail.com>"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "glib-2.0 gtk+ libgee cairo hmc5843 lis302dl"
RDEPENDS_${PN} = "glib-2.0 gtk+ libgee cairo"
RSUGGESTS_${PN} = ""
PV = "0.1+gitr${SRCPV}"
PR = "r1"

SRC_URI = "git://gitorious.org/vala-compass/vala-compass.git;protocol=git;branch=master"

SRCREV = "0214a81c6ab3d8604233588ae5727b851fde236d"
S = "${WORKDIR}/git"

inherit autotools vala

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

MAINTAINER = "Michele Brocco <ssj2micvm@gmail.com>"
