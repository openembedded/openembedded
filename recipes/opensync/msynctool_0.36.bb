SRC_URI = "http://www.opensync.org/download/releases/${PV}/msynctool-${PV}.tar.bz2"

LICENSE = "GPL"
DEPENDS = "libopensync glib-2.0"
HOMEPAGE = "http://www.opensync.org/"

inherit cmake pkgconfig

SRC_URI[md5sum] = "9ef1c03d1e087493dbca67dabb612e6b"
SRC_URI[sha256sum] = "de08e22708348216e0e1ea3c32b4cf0c04d5acae5057b5995fc087790f0ae1a5"
