LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE Desktop Manager"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "glib-2.0 xserver-common login-manager"
RDEPENDS_${PN} += "xserver-common login-manager"
PR = "r1"

SRC_URI += "file://multi-lm.patch;patch=1"

