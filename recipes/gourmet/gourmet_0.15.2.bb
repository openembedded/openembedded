DESCRIPTION = "Gourmet is a MealMaster-compatible recipe manager"
AUTHOR = "Thomas Hinkle <thomas_hinkle@users.sourceforge.net>"
HOMEPAGE = "http://grecipe-manager.sf.net"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ python-pygtk"
RDEPENDS = "python-core"

SRC_URI = "${SOURCEFORGE_MIRROR}/grecipe-manager/${PN}-${PV}.tar.gz"

inherit distutils



