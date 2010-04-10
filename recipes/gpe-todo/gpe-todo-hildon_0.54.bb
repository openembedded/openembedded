LICENSE     = "GPL"
PR          = "r0"
DESCRIPTION = "GPE to-do list"
DEPENDS     = "libgpewidget-hildon libgpepimc-hildon libtododb sdk-default-icons libosso"
RDEPENDS    = "sdk-default-icons"
SECTION = "gpe"
PRIORITY    = "optional"

inherit gpe autotools pkgconfig

EXTRA_OECONF = "--enable-hildon"

SRC_URI="${GPE_MIRROR}/gpe-todo-${PV}.tar.bz2"

S = "${WORKDIR}/gpe-todo-${PV}"

FILES_${PN} += "${datadir}/gpe-todo ${libdir}/dbus-1.0"

SRC_URI[md5sum] = "8fdd52954a7a29691013900b65eb5702"
SRC_URI[sha256sum] = "b3f51635b3ce6408fdfbd0283e1d8036c23b6ecb5adf0d66882e7e48eb5d97b9"
