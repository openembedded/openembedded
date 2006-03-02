PV = "0.0+cvs${SRCDATE}"
LICENSE = "BSD-X"
SECTION = "x11"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "libx11 libxdamage libxcomposite libxrender"
DESCRIPTION = "X Compositing Manager"

SRC_URI = "${FREEDESKTOP_CVS}/xapps;module=xcompmgr"
S = "${WORKDIR}/xcompmgr"

inherit autotools 
