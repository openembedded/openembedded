require navit.inc

PV = "0.1.0+svnrev${SRCREV}"
PR = "r5"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF_shr += " --enable-cache-size=20971520 --with-svg2png-use-convert"

S = "${WORKDIR}/navit"

SRC_URI = "svn://anonymous@navit.svn.sourceforge.net/svnroot/navit/trunk;module=navit;proto=https"

EXTRA_AUTORECONF = " -I m4"
