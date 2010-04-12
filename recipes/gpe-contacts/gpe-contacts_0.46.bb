DESCRIPTION = "GPE contacts manager"
LICENSE = "GPL"
SECTION = "gpe"

DEPENDS = "libcontactsdb libgpewidget libgpepimc libdisplaymigration libgpevtype dbus-glib"
RDEPENDS = "gpe-icons"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools

FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"


SRC_URI[md5sum] = "5fcffd454e9c8f0b14804283c32da0ee"
SRC_URI[sha256sum] = "5ceab2c275036da754ae7b7cbe162f9f2a5936334050beb34838d4f82e89843c"
