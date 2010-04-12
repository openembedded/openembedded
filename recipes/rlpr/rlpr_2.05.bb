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

SRC_URI[md5sum] = "64ee8ccd94aabc90b9f40d0b2ad79e79"
SRC_URI[sha256sum] = "6b1261c8a23a58c8e174d8ee1ad53c138ed0b9211f7ea3f3efe22d16af14ba9a"
