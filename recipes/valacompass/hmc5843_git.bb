DESCRIPTION = "Library for easy-accessing the 3d comapss HMC5843 from Honeywell "
AUTHOR = "Michele Brocco <ssj2micvm@gmail.com>"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "glib-2.0"
RDEPENDS_${PN} = "glib-2.0"
RSUGGESTS_${PN} = ""
PV = "0.1+gitr${SRCPV}"
PR = "r1"

SRC_URI = "git://gitorious.org/sensor-monitor/libhmc5843.git;protocol=git;branch=master"

SRCREV = "9cdf5141ad050c87630fe28684dbb13d93aeca46"
S = "${WORKDIR}/git"

inherit autotools vala

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

MAINTAINER = "Michele Brocco <ssj2micvm@gmail.com>"
