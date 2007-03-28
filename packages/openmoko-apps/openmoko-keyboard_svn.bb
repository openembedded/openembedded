DESCRIPTION = "Matchbox virtual keyboard for X11 - OpenMoko fork"
LICENSE = "GPL"
DEPENDS = "libfakekey expat libxft"
SECTION = "openmoko/input-methods"
PV = "0.0+svn${SRCDATE}"

inherit openmoko autotools pkgconfig gettext

SRC_URI = "${OPENMOKO_MIRROR}/src/target/${OPENMOKO_RELEASE}/applications;module=${PN};proto=http"

S = "${WORKDIR}/${PN}"

EXTRA_OECONF = "--disable-cairo"

FILES_${PN} = "${bindir}/* \
	       ${datadir}/applications \
	       ${datadir}/pixmaps \
	       ${datadir}/openmoko-keyboard"

