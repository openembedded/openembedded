DESCRIPTION = "Examine, the program configurator"
DEPENDS = "ewl"
LICENSE = "MIT"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r0"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/examine"
S = "${WORKDIR}/examine"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
