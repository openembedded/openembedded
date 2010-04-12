DESCRIPTION = "Network Block Device"
LICENSE = "GPLv2"
HOMEPAGE = "http://nbd.sourceforge.net"

DEPENDS = "glib-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2;md5sum=bc7995b4961385269abc645575bcaf4d \
           file://cross-compile.patch;patch=1 "

inherit autotools


PACKAGES = "nbd-client nbd-server nbd-client-dbg nbd-server-dbg"
PACKAGES += "nbd-client-doc nbd-server-doc"

FILES_nbd-client = "/usr/sbin/nbd-client"
FILES_nbd-server = "/usr/bin/nbd-server"
FILES_nbd-client-dbg += "/usr/sbin/.debug/nbd-client"
FILES_nbd-server-dbg += "/usr/bin/.debug/nbd-server"
FILES_nbd-client-doc = "/usr/share/man/man8/*"
FILES_nbd-server-doc = "/usr/share/man/man1/*"

SRC_URI[md5sum] = "bc7995b4961385269abc645575bcaf4d"
SRC_URI[sha256sum] = "a69d1690ad587d81b85c34d1ef9bf47abf0ba21dc96876d95dd6a9a193a859f1"
