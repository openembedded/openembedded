DESCRIPTION = "Matchbox GTK+ theme configuration application."
LICENSE = "GPL"
DEPENDS = "gconf gtk+"
RDEPENDS = "settings-daemon"

SRCREV = "1614"
PV = "0.0+svnr${SRCPV}"

S = "${WORKDIR}/${PN}"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http \
        file://no-handed.patch;patch=1;pnum=0"

inherit autotools pkgconfig

