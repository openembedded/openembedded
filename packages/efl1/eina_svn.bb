DESCRIPTION = "EET is the Enlightenment data storage library"
DEPENDS = ""
LICENSE = "LGPL"
PV = "0.0.1+svnr${SRCREV}"
PR = "r1"

inherit efl

EXTRA_OECONF = "\
"

FILES_${PN} += "${libdir}/eina"
