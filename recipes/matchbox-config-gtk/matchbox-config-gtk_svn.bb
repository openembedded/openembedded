DESCRIPTION = "Matchbox GTK+ theme configuration application."
LICENSE = "GPL"
DEPENDS = "gconf gtk+"
RDEPENDS_${PN} = "settings-daemon"
PR = "r1"

SRCREV = "1614"
PV = "0.0+svnr${SRCPV}"

S = "${WORKDIR}/${PN}"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http \
        file://no-handed.patch;striplevel=0"

inherit autotools pkgconfig

