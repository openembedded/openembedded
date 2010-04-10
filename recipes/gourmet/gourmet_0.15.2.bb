DESCRIPTION = "Gourmet is a MealMaster-compatible recipe manager"
AUTHOR = "Thomas Hinkle <thomas_hinkle@users.sourceforge.net>"
HOMEPAGE = "http://grecipe-manager.sf.net"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ python-pygtk"
RDEPENDS = "python-core"

SRC_URI = "${SOURCEFORGE_MIRROR}/grecipe-manager/${PN}-${PV}.tar.gz"

inherit distutils




SRC_URI[md5sum] = "d18be0dd5faf7249f657c4cc87105c31"
SRC_URI[sha256sum] = "d1130c71a876f333707aa8dd8b9689a0aaf115e782ec4a033359eb2995942848"
