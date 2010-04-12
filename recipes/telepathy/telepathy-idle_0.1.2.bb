DESCRIPTION = "IRC connection manager for Telepathy"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus telepathy-glib openssl"
LICENSE = "LGPL"

SRC_URI = "http://telepathy.freedesktop.org/releases/${PN}/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/telepathy \
                ${datadir}/dbus-1"

SRC_URI[md5sum] = "21bfda9e1fa12e25b4173deb9ffd0b5d"
SRC_URI[sha256sum] = "3ed0cb5dd687e4d9fa838a318f9ef12a8c221894ff188687c27625f0ac3bce82"
