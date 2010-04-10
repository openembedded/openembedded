DESCRIPTION = "GUI frontend for sword"
HOMEPAGE = "http://gnomesword.sf.net"
LICENSE = "GPLv3"
DEPENDS = "libgnomeui gtkhtml-3.6 virtual/gail sword"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig



SRC_URI[md5sum] = "ce1171f19a40256cfdd31f42c979d91c"
SRC_URI[sha256sum] = "77cb4bd39a4cec2aa3d61b0519134f9e4a65613960b3b3ee34dd2452d5e12ba7"
