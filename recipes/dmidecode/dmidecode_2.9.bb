DESCRIPTION = "DMI (Desktop Management Interface) table related utilities"
HOMEPAGE = "http://www.nongnu.org/dmidecode/"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "http://savannah.nongnu.org/download/dmidecode/${P}.tar.bz2"

COMPATIBLE_HOST = "i.86.*-linux"

do_unpack_extra() {
	sed -i \
	    -e '/^prefix/s:/usr/local:/usr:' \
	    Makefile
}
addtask unpack_extra after do_unpack before do_patch

do_install() {
	oe_runmake DESTDIR="${D}" install
}

SRC_URI[md5sum] = "3dac4b1817012ffebd78671473d8f56c"
SRC_URI[sha256sum] = "888eb2c25bdcef5ee34c38cd5cb0f491d7dd82029dc0f4ae96183a0088a5e015"
