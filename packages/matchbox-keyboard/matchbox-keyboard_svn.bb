DESCRIPTION = "Matchbox keyboard"
LICENSE = "GPL"
DEPENDS = "libmb libfakekey expat libxft"
SECTION = "x11/wm"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http"

S = ${WORKDIR}/${PN}

inherit autotools pkgconfig gettext

FILES_${PN} = "${bindir} \
	       ${datadir}/applications \
	       ${datadir}/pixmaps"

