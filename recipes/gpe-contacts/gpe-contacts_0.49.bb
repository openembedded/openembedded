DESCRIPTION = "GPE contacts manager"
LICENSE = "GPL"
SECTION = "gpe"

DEPENDS = "libcontactsdb libgpewidget libgpepimc libdisplaymigration libgpevtype dbus-glib"
RDEPENDS = "gpe-icons"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools

FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"


SRC_URI[md5sum] = "baa489f258844a65167e75345857acf6"
SRC_URI[sha256sum] = "9d98d52c3915ca966abd02208847d50f7190aab6f95c5f156f7c20285fe2d9f6"
