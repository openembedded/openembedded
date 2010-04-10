SECTION = "console/utils"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/desktop-file-utils"
DESCRIPTION = "command line utilities to work with *.desktop files"
LICENSE = "GPL"

DEPENDS = "glib-2.0-native"

SRC_URI = "http://freedesktop.org/software/desktop-file-utils/releases/desktop-file-utils-${PV}.tar.gz"

inherit autotools native

S = "${WORKDIR}/desktop-file-utils-${PV}"

SRC_URI[md5sum] = "e0b5057a4e3166f34635ac6f27c712c0"
SRC_URI[sha256sum] = "97856d2621d4e3273340b7f1172c2e074c74263629b05bde0f0f077425ec0699"
