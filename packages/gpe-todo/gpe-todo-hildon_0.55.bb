LICENSE     = "GPL"
PR          = "r0"
DESCRIPTION = "GPE to-do list"
DEPENDS     = "libgpewidget-hildon libgpepimc-hildon libtododb sdk-default-icons libosso"
RDEPENDS    = "sdk-default-icons"
MAINTAINER  = "Florian Boor <florian@kernelconcepts.de>"
SECTION     = "gpe"
PRIORITY    = "optional"

inherit gpe autotools pkgconfig

EXTRA_OECONF = "--enable-hildon"

SRC_URI="${GPE_MIRROR}/gpe-todo-${PV}.tar.bz2"

S = "${WORKDIR}/gpe-todo-${PV}"

FILES_${PN} += "${datadir}/gpe-todo ${libdir}/dbus-1.0"
