DESCRIPTION = "Matchbox keyboard"
LICENSE = "GPL"
DEPENDS = "libfakekey expat libxft"
SECTION = "x11/wm"
SRCREV = "1820"
PV = "0.0+svnr${SRCPV}"

PR ="r2"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http"


S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig gettext

FILES_${PN} = "${bindir}/* \
	       ${datadir}/applications \
	       ${datadir}/pixmaps \
		${datadir}/matchbox-stroke"
