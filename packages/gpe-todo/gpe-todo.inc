LICENSE = "GPL"
inherit gpe autotools pkgconfig

DESCRIPTION = "GPE to-do list"
DEPENDS = "libgpewidget libgpepimc libtododb"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI="${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

