DESCRIPTION = " Enlightenment Web Browser"
LICENSE = "GPL"
DEPENDS = "evas ecore edje elementary webkit-efl"
PR = "r1"
PV = "0.3.0.0+svnr${SRCPV}"
SRCREV = "${EFL_SRCREV}"

PR = "r1"

inherit e

SRC_URI += "file://eve-theme-for-smaller-screens.patch"

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
"

FILES_${PN} += "\
        ${datadir}/icons/eve.png \
"
