DESCRIPTION="a freedesktop.org compliant menu library for Xfce4"
HOMEPAGE="http://www.xfce.org/projects/libraries"
DEPENDS = "gettext pkgconfig libxfce4util intltool"
RDEPENDS = "gtk+ libxfce4util"

LICENSE="LGPL-2 FDL-1.1"
PR = "r1"

inherit xfce46

do_stage() {
   autotools_stage_all
}

SRC_URI[md5sum] = "5dc9343885c2c6f931318b2a1cdcc9db"
SRC_URI[sha256sum] = "5442b458b0e4f6bbbb6ddfbf1a7789dde1d270ab85686a3be77731a4d5ef84da"
