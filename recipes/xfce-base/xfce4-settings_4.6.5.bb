DESCRIPTION = "Xfce4 settings"
HOMEPAGE = "http://www.xfce.org"
SECTION = "x11/wm"
LICENSE = "GPL-2"

DEPENDS = "virtual/libx11 virtual/xserver libxi libwnck xrandr exo libxfce4util libxfcegui4"

PR = "r0"

inherit xfce46

SRC_URI[md5sum] = "f988cb732913b5fbc115ad7105d2231e"
SRC_URI[sha256sum] = "1601b8d2cac5d931c39bed7e331c5bd91018d0e56663295e7a083a2c78fe168b"

RDEPENDS_${PN} = "xfconf exo"

