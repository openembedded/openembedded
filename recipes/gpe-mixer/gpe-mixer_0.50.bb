DESCRIPTION = "GPE audio mixer"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"
PR = "r0"

inherit gpe autotools pkgconfig
SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"