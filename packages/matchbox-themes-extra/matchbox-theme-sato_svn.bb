DESCRIPTION = "Matchbox window manager Sato theme"
LICENSE = "GPL"
DEPENDS = "matchbox-wm"
SECTION = "x11/wm"

PV = "0.1+svn${SRCDATE}"
PR = "r0"

PACKAGE_ARCH = "all"

SRC_URI = "svn://svn.o-hand.com/repos/sato/trunk;module=matchbox-sato;proto=http"
S = "${WORKDIR}/matchbox-sato"

inherit autotools pkgconfig

FILES_${PN} = "${datadir}/themes/Sato"


