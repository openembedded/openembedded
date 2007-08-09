DESCRIPTION = "GPE contacts manager"
LICENSE = "GPL"
SECTION = "gpe"

DEPENDS = "libcontactsdb libgpewidget libgpepimc libdisplaymigration libgpevtype dbus-glib"
RDEPENDS = "gpe-icons"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools

FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"

