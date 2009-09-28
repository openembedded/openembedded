DESCRIPTION = "Matchbox Window Manager Desktop"
LICENSE = "GPL"
SECTION = "x11/panels"
DEPENDS = "gtk+ startup-notification"
RDEPENDS = "matchbox-common"
PV = "2.0+svnr${SRCREV}"
PR = "r0"

inherit autotools_stage pkgconfig

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http"
S = "${WORKDIR}/${PN}"

#PARALLEL_MAKE = ""

EXTRA_OECONF = "--program-transform-name='s/$/-2/'"
