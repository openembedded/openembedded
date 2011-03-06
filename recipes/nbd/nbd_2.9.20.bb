DESCRIPTION = "Network Block Device"
LICENSE = "GPLv2"
HOMEPAGE = "http://nbd.sourceforge.net"
DEPENDS = "glib-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2"
SRC_URI[md5sum] = "aec35f6beb7bb4cb2ee267fe0f72c8d6"
SRC_URI[sha256sum] = "98f0de421f0b2f683d46dff3eb679a3409a41f08e6fad7c2f71f60c5d409939c"

inherit autotools

PACKAGES = "nbd-client nbd-server nbd-client-dbg nbd-server-dbg"
PACKAGES += "nbd-client-doc nbd-server-doc"

FILES_nbd-client = "/usr/sbin/nbd-client"
FILES_nbd-server = "/usr/bin/nbd-server"
FILES_nbd-client-dbg += "/usr/sbin/.debug/nbd-client"
FILES_nbd-server-dbg += "/usr/bin/.debug/nbd-server"
FILES_nbd-client-doc = "/usr/share/man/man8/*"
FILES_nbd-server-doc = "/usr/share/man/man1/*"
