LICENSE = "GPL"
inherit gpe autotools

PR = "r2"

DEPENDS = "libgpewidget libgpepimc libdisplaymigration libgpevtype dbus"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE contacts manager"
SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
		file://lost-icons.patch;patch=1;pnum=0"


FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"

