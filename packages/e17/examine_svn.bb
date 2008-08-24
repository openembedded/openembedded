DESCRIPTION = "Examine, the program configurator"
LICENSE = "MIT BSD"
DEPENDS = "ewl"
PV = "0.0.1+svnr${SRCREV}"
PR = "r1"

SRCNAME = "examine"

inherit e

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
