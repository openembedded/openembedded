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

SRC_URI[md5sum] = "e8c08165d9723779473e3390a949afac"
SRC_URI[sha256sum] = "ec2ef95c967acce5834c8b4985c610014c16242d223d233947d67b4514ebe298"
