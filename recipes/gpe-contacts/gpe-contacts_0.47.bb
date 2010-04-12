DESCRIPTION = "GPE contacts manager"
LICENSE = "GPL"
SECTION = "gpe"

DEPENDS = "libcontactsdb libgpewidget libgpepimc libdisplaymigration libgpevtype dbus-glib"
RDEPENDS = "gpe-icons"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools

FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"


SRC_URI[md5sum] = "c956ed93b8a163c046e9a7c19256432d"
SRC_URI[sha256sum] = "aa9656db3e46b27abf7564f2a04799f4b32e4c342e3036d069d456b103717bc5"
