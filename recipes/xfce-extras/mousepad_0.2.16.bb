DESCRIPTION = "Text editor for Xfce based on Leafpad"
RDEPENDS = "libxfce4util hal"
SECTION = "x11"
PR = "r2"

inherit xfce46

SRC_URI = "http://mocha.xfce.org/archive/src/apps/${PN}/${@'${PV}'[0:3]}/${PN}-${PV}.tar.bz2"


SRC_URI[md5sum] = "d98854edb76d823ac20b266fdf5a64a1"
SRC_URI[sha256sum] = "86e593fd4b1b87d27cda9ebd8901078e795031b5880645850d6ef0b410f4e73e"
