DESCRIPTION = "Telepathy framework - Python package"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
LICENSE = "LGPL"
RDEPENDS_${PN} += "python-dbus"

SRC_URI = "http://telepathy.freedesktop.org/releases/${PN}/${P}.tar.gz "

inherit distutils

SRC_URI[md5sum] = "a42cc4defcaf46099e07972ece791c2d"
SRC_URI[sha256sum] = "3065fae35064c22380963a0d29a04bedb86c05e51d3af84c73f3da8f2107cb2d"
