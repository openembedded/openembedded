PV = "0.0cvs${CVSDATE}"
LICENSE = "BSD-X"
SECTION = "x11"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "x11 xdamage xcomposite libxrender"
DESCRIPTION = "X Compositing Manager"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xapps;module=xcompmgr"
S = "${WORKDIR}/xcompmgr"

inherit autotools 
