PR = "r0"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>
LICENSE  = "BERKLEY"
DEPENDS  = "openssl ortp speex expat"
PROVIDES = "libjingle"
CVSDATE  = 20060322
SRCDATE  = ${CVSDATE}
PV = "0.3.0+tapiocasvn${SRCDATE}"

inherit autotools pkgconfig

SRC_URI = "svn://svn.sourceforge.net/svnroot/tapioca-voip/trunk;module=libjingle;proto=https"

S = "${WORKDIR}/libjingle"

do_stage () {
	autotools_stage_all
}
