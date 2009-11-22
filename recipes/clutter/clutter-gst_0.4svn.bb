require clutter-gst.inc

PV = "0.4.0+svnr${SRCPV}"

SRC_URI = "svn://svn.o-hand.com/repos/clutter/branches;module=clutter-gst-0-4;proto=http \
           file://autofoo-0.4.patch;patch=1"


S = "${WORKDIR}/clutter-gst-0-4"
