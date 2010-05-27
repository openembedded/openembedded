DESCRIPTION = "nl80211 based CLI configuration utility for wireless devices"
HOMEPAGE = "http://linuxwireless.org/en/users/Documentation/iw"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "r0"

DEPENDS = "libnl pkgconfig"

SRC_URI = "http://wireless.kernel.org/download/iw/${P}.tar.bz2"

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
}

SRC_URI[md5sum] = "3b88743f9c6ce8a7e2f5fd7d18fdea42"
SRC_URI[sha256sum] = "f59191bb9c50bc64787fff65037de597b6c5ee790622a088e4bab85287798a8c"
