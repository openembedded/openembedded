DESCRIPTION = "Vala application for monitoring raw sensor values on the handheld"
AUTHOR = "Michele Brocco <ssj2micvm@gmail.com>"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "glib-2.0 gtk+ libgee cairo libsensmon"
RDEPENDS_${PN} = "glib-2.0 gtk+ libgee cairo"
RSUGGESTS_${PN} = ""
PV = "0.21+gitr${SRCPV}"
PR = "r1"

SRC_URI = "git://gitorious.org/sensor-monitor/sensor-monitor.git;protocol=git;branch=master"

SRCREV = "bb2f8dfd5615abec96cc3e19a354e24a22991a4c"
S = "${WORKDIR}/git"

inherit autotools vala

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

MAINTAINER = "Michele Brocco <ssj2micvm@gmail.com>"
