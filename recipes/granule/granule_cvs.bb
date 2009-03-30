require granule.inc

PV = "1.2.4+cvs${SRCDATE}"

EXTRA_OECONF_append_h3600 = " --enable-pda=yes "
EXTRA_OECONF_append_h3900 = " --enable-pda=yes "
EXTRA_OECONF_append_h2200 = " --enable-pda=yes "
EXTRA_OECONF_append_h4000 = " --enable-pda=yes "
EXTRA_OECONF_append_collie = " --enable-pda=yes "
EXTRA_OECONF_append_poodle = " --enable-pda=yes "
EXTRA_OECONF_append_mnci = " --enable-pda=yes "
EXTRA_OECONF_append_integral13 = " --enable-pda=yes "

SRC_URI = "cvs://anonymous@granule.cvs.sourceforge.net/cvsroot/granule;method=pserver;module=granule"

S = "${WORKDIR}/granule"

