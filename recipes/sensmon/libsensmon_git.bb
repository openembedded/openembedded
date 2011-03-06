DESCRIPTION = "Library for easy-accessing the sensors supported by sensmon"
AUTHOR = "Michele Brocco <ssj2micvm@gmail.com>"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "glib-2.0"
RDEPENDS_${PN} = "glib-2.0"
RSUGGESTS_${PN} = ""
PV = "0.1+gitr${SRCPV}"
PR = "r1"

SRC_URI = "git://gitorious.org/sensor-monitor/libsensmon.git;protocol=git;branch=master"

SRCREV = "1e986a6d84d4a63ffa85a049bdfced00bad8d97a"
S = "${WORKDIR}/git"

inherit autotools vala

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

MAINTAINER = "Michele Brocco <ssj2micvm@gmail.com>"
