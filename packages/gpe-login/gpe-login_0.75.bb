LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS = "xkbd"
RPROVIDES = "gpe-session-starter"
PR = "r3"

SRC_URI += "file://pre-session.patch;patch=1 \
	    file://user-own-collie-devs.patch;patch=1"
