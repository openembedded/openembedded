LICENSE = "GPL"
inherit gpe autotools

PR = "r0"

DEPENDS = "libcontactsdb libgpewidget libgpepimc libdisplaymigration libgpevtype dbus-glib"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE contacts manager"
SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"


FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"


SRC_URI[md5sum] = "8d7af11536ce8d7a732ed62d2b36bba6"
SRC_URI[sha256sum] = "f35c5e664ba0e9c3b3d694cdb1ee9af7c9195b6ace8e2ddeec0a0c21d7632df0"
