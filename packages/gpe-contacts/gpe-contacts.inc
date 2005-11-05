LICENSE = "GPL"
inherit gpe autotools pkgconfig

PR = "r0"

DEPENDS = "libgpewidget libdisplaymigration libgpevtype dbus"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE contacts manager"
SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"


FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"

