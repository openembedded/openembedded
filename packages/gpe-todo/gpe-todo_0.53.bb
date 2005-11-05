LICENSE = "GPL"
inherit gpe autotools pkgconfig

DESCRIPTION = "GPE to-do list"
DEPENDS = "gtk+ libgpewidget libgpepimc libtododb"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI="http://ftp.handhelds.org/pub/projects/gpe/source/${PN}-${PV}.tar.bz2"

