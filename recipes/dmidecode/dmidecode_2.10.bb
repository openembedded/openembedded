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
