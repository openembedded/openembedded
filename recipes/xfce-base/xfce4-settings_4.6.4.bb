DESCRIPTION = "Xfce4 settings"
HOMEPAGE = "http://www.xfce.org"
SECTION = "x11/wm"
LICENSE = "GPL-2"

DEPENDS = "virtual/libx11 virtual/xserver libxi libwnck xrandr exo libxfce4util"

inherit xfce46

SRC_URI += "file://0001-Port-to-libxklavier-5.0-API.patch" 

SRC_URI[md5sum] = "04985407e8e5b916c44780314a177e96"
SRC_URI[sha256sum] = "a5e3f0d959b0d424355414769250473785043c3977446a73b36fa3a5ce44ecdb"

RDEPENDS_${PN} = "xfconf exo"

