require qpegps.inc

PV = "0.0+svn${SRCDATE}"
PR = "r1"

SRC_URI = "svn://qpegps.svn.sourceforge.net/svnroot/;module=qpegps/trunk/qpegps;proto=https \
           file://qpegps.desktop \
           file://qpegps.png "

S = "${WORKDIR}/qpegps/trunk/qpegps"

do_configure_prepend() {
         mv ${S}/Place.cpp ${S}/place.cpp
         mv ${S}/Place.h ${S}/place.h
}
