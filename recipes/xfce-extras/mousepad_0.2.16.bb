DESCRIPTION = "Text editor for Xfce based on Leafpad"
RDEPENDS = "libxfce4util hal"
SECTION = "x11"
PR = "r2"

inherit xfce46

SRC_URI = "http://mocha.xfce.org/archive/src/apps/${PN}/${@'${PV}'[0:3]}/${PN}-${PV}.tar.bz2"

