DESCRIPTION = "DMI (Desktop Management Interface) table related utilities"
SECTION = "console/utils"
HOMEPAGE = "http://www.nongnu.org/dmidecode/"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "http://savannah.nongnu.org/download/dmidecode/${P}.tar.bz2"

COMPATIBLE_HOST = "(i.86|x86_64).*-linux"

do_install() {
	oe_runmake DESTDIR="${D}" install
}

SRC_URI[md5sum] = "3c9c4d55a40b78600f3b43bfa64616f9"
SRC_URI[sha256sum] = "4d74a3e93353320317a424816f9a045df06d9ed4b5b80881e16fdfcc74c9e2c0"
