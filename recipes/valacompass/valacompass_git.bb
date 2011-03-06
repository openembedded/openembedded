DESCRIPTION = "Compass written in vala that uses the hmc5843 compass and the lis302dl accelerometer"
AUTHOR = "Michele Brocco <ssj2micvm@gmail.com>"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "glib-2.0 gtk+ libgee cairo libsensmon"
RDEPENDS_${PN} = "glib-2.0 gtk+ libgee cairo"
RSUGGESTS_${PN} = ""
PV = "0.11+gitr${SRCPV}"
PR = "r1"

SRC_URI = "git://gitorious.org/vala-compass/vala-compass.git;protocol=git;branch=master"

SRCREV = "9ca9b568a055ff2412f0d642987421178334e683"
S = "${WORKDIR}/git"

inherit autotools vala

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

MAINTAINER = "Michele Brocco <ssj2micvm@gmail.com>"
