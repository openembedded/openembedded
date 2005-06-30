LICENSE = "GPL"
inherit gpe

PR = "r0"

DEPENDS = "libgpewidget libgpepimc libdisplaymigration libgpevtype libxml2 dbus"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE contacts manager"

FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"

