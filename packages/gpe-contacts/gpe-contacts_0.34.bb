LICENSE = "GPL"
inherit gpe

PR = "r0"

DEPENDS = "libgpewidget libgpepimc libdisplaymigration libgpevtype dbus"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE contacts manager"

FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"

