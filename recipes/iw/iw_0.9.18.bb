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

SRC_URI[md5sum] = "9734080d8a5c4b768c5e0da665a48950"
SRC_URI[sha256sum] = "b02e26efc72cb23129431e478dbb2f2abd16e8cc4f4130762d98c54f106aabd0"
