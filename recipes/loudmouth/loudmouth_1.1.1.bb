LICENSE = "LGPL"
DEPENDS = "glib-2.0 gnutls check"
DESCRIPTION = "Loudmouth is a lightweight and easy-to-use C library for programming with the Jabber protocol."

SRC_URI = "http://ftp.imendio.com/pub/imendio/${PN}/src/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "7abcba853b45a8595333da9aa807623c"
SRC_URI[sha256sum] = "f7614a14e2ae31b2ba22e419f78ba0d21afbb98fdeb24ae117327c3c8af05f1d"
