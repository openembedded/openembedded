DESCRIPTION = "Telepathy framework - Python package"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
LICENSE = "LGPL"
RDEPENDS_${PN} += "dbus-python"

SRC_URI = "http://telepathy.freedesktop.org/releases/${PN}/${P}.tar.gz "

inherit distutils
