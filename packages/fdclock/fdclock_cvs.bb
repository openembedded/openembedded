PV = "0.0cvs${CVSDATE}"
LICENSE = "BSD-X"
SECTION = "x11"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "cairo"
DESCRIPTION = "The freedesktop.org clock"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xapps;module=fdclock"
S = "${WORKDIR}/fdclock"

inherit autotools 
