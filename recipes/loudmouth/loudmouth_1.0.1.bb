LICENSE = "LGPL"
DEPENDS = "glib-2.0 gnutls"
DESCRIPTION = "Loudmouth is a lightweight and easy-to-use C library for programming with the Jabber protocol."

SRC_URI = "http://ftp.imendio.com/pub/imendio/${PN}/src/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "d43408ecb82dcbacfc965b4bb989e9c3"
SRC_URI[sha256sum] = "c7cdd8ebffedf878e7b7d5d3848ecaacec4a7d57afd29602c2c9d64f0d8b5a63"
