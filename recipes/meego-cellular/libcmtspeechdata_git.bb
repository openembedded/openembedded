DESCRIPTION = "Library for cellular speech data path on Nokia N900"
LICENSE = "LGPL"
DEPENDS = "check"

SRC_URI = "git://git.gitorious.org/meego-cellular/libcmtspeechdata.git;protocol=http"
SRCREV = "845034568692d289573e18163d497fce6177cffb"
PV = "0.0.0+gitr${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools
