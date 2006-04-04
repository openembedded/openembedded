DESCRIPTION = "examine, the program configurator"
DEPENDS = "virtual/ecore ewl"
LICENSE = "MIT"
PR = "r0"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/examine;date=${PV}"
S = "${WORKDIR}/examine"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
