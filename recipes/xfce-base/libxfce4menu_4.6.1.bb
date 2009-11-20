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
