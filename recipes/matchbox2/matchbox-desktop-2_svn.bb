DESCRIPTION = "Matchbox Window Manager Desktop"
LICENSE = "GPL"
SECTION = "x11/panels"
DEPENDS = "gtk+ startup-notification"
RDEPENDS = "matchbox-common"
PV = "2.0+svnr${SRCPV}"
PR = "r1"

inherit autotools_stage pkgconfig

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http \
	   file://fallback-folder.patch;patch=1;pnum=0 \
"
S = "${WORKDIR}/${PN}"

EXTRA_OECONF = "--program-transform-name='s/$/-2/'"
