DESCRIPTION="a freedesktop.org compliant menu library for Xfce4"
HOMEPAGE="http://www.xfce.org/projects/libraries"
DEPENDS = "gettext pkgconfig libxfce4util intltool"
RDEPENDS_${PN} = "gtk+ libxfce4util"

LICENSE="LGPL-2 FDL-1.1"
PR = "r0"

inherit xfce46

SRC_URI[md5sum] = "ff10cacb76803ee37159e3a43345f0d1"
SRC_URI[sha256sum] = "62352be57318d6f241c4f6e4b6f9303d0b80246ea8f6e4753a962360a9965162"
