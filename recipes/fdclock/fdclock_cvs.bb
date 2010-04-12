SRCDATE = "20060814"
PV = "0.0+cvs${SRCDATE}"
LICENSE = "BSD-X"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "cairo"
DESCRIPTION = "The freedesktop.org clock"

SRC_URI = "${FREEDESKTOP_CVS}/xapps;module=fdclock"
S = "${WORKDIR}/fdclock"

inherit autotools
