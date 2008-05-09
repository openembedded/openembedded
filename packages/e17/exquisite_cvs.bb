DESCRIPTION = "A psplash replacement for display"
LICENSE = "MIT BSD"
DEPENDS = "eet evas ecore embryo edje"
PV = "0.0.1+cvs${SRCDATE}"
PR = "r0"

SRCNAME = "exquisite"

inherit e

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"
