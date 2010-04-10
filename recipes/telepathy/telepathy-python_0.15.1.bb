DESCRIPTION = "Telepathy framework - Python package"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
LICENSE = "LGPL"
RDEPENDS_${PN} += "python-dbus"

SRC_URI = "http://telepathy.freedesktop.org/releases/${PN}/${P}.tar.gz "

inherit distutils

SRC_URI[md5sum] = "b3e9bd31393c4cebbd8077b62b2bcd8c"
SRC_URI[sha256sum] = "02a5c752201e016905c75503217af5a25eebe3f6a4e02a75173ed34021401296"
