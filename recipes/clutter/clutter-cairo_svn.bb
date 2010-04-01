require clutter-cairo.inc

PV = "0.8.0+svnr${SRCPV}"
SRCREV = "3210"

SRC_URI = "svn://svn.o-hand.com/repos/clutter/trunk;module=${PN};proto=http \
           file://enable_examples.patch;patch=1"

S = "${WORKDIR}/${PN}"


