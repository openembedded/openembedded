DESCRIPTION = "GeeXboX libNFO is a small library aiming at parsing and writing NFO files."
HOMEPAGE = "http://libnfo.geexbox.org/"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2+"
DEPENDS = "libxml2"

INC_PR = "r0"

SRC_URI = "http://libnfo.geexbox.org/releases/${PN}.tar.bz2;name=${PN}"

inherit autotools pkgconfig

# the configure script is hand-crafted, it rejects some of the usual
# configure arguments
do_configure() {
	${S}/configure \
			--prefix=${prefix} \
		--disable-strip \
		--cross-compile \
		--enable-pic \
		--enable-doc
}

PACKAGES =+ "${PN}-bin"

FILES_${PN}-bin = "${bindir}/*"
