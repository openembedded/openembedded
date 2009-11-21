require navit.inc

PV = "0.1.0+svnr${SRCPV}"
PR = "r0"

DEPENDS_shr += " librsvg-native"
EXTRA_OECONF_shr += " --enable-cache-size=20971520"

S = "${WORKDIR}/navit"

SRC_URI = "svn://anonymous@navit.svn.sourceforge.net/svnroot/navit/trunk;module=navit;proto=https"

EXTRA_AUTORECONF = " -I m4"
