DESCRIPTION = "Examine, the program configurator"
DEPENDS = "ewl"
LICENSE = "MIT BSD"
PV = "0.0.1+cvs${SRCDATE}"
PR = "r0"

inherit e

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
