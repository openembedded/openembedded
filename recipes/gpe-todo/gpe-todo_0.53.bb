LICENSE = "GPL"
inherit gpe autotools pkgconfig

DESCRIPTION = "GPE to-do list"
DEPENDS = "gtk+ libgpewidget libgpepimc libtododb"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI="${GPE_MIRROR}/${PN}-${PV}.tar.bz2"


SRC_URI[md5sum] = "b96e83e2e02ef55474878500587fd2a2"
SRC_URI[sha256sum] = "b9b7a165ffd1998ac09ddf9359d2005f4f2dbc995887b9c9a4fec959e3f32646"
