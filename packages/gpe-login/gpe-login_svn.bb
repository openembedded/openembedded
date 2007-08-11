DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS = "xkbd"
RPROVIDES_${PN} = "gpe-session-starter"
PV = "0.90+svn${SRCDATE}"

inherit autotools

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

SRC_URI = "${GPE_SVN} \
	   file://removeblue-fontsize8.patch;patch=1"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
