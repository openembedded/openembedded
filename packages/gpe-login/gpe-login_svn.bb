DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS = "xkbd"
RPROVIDES = "gpe-session-starter"
PV = "0.88+svn-${SRCDATE}"

inherit autotools

SRC_URI = "${GPE_SVN} \
	   file://removeblue-fontsize8.patch;patch=1"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
