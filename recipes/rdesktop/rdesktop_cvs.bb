require rdesktop.inc

SRCDATE = "20080917"
PV = "1.6.0+cvs${SRCDATE}"
PR = "${INC_PR}.1"
DEFAULT_PREFERENCE = "-1"
SRC_URI = "cvs://anonymous@rdesktop.cvs.sourceforge.net/cvsroot/rdesktop;module=rdesktop"
S = "${WORKDIR}/rdesktop"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_LIBDIR}/.. "
