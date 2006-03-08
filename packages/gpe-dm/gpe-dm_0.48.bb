LICENSE = "GPL"
inherit gpe update-rc.d

DESCRIPTION = "GPE Display Manager"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "glib-2.0 xserver-common"
RDEPENDS_${PN} += "xserver-common"
PR = "r2"

INITSCRIPT_NAME = "gpe-dm"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."

