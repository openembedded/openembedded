DESCRIPTION = "openbox configuration program"
AUTHOR = "icculus.org/openbox"
HOMEPAGE_URL="http://icculus.org/openbox/index.php/ObConf:About"

PR = "r0"

DEPENDS = "openbox gtk+ libglade"
RDEPENDS = "openbox gtk+"
SRC_URI = "http://icculus.org/openbox/${PN}/${PN}-${PV}.tar.gz"
S = "${WORKDIR}/${PN}-${PV}"

inherit pkgconfig autotools