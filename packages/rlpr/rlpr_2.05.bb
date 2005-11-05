SECTION = "console/network"
DESCRIPTION = "rlpr makes it possible to print files on remote sites to your networked printers"
HOMEPAGE = "http://truffula.com/rlpr/"
LICENSE = "GPL"
SRC_URI = "ftp://www.truffula.com/pub/rlpr-2.05.tar.gz"

inherit autotools

do_configure() {
	oe_runconf
}

do_install() {
	make install DESTDIR=${D}
}
