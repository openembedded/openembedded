DESCRIPTION = "libplayer is a multimedia A/V abstraction layer API. Its goal is to interact with Enna Media Center."
HOMEPAGE = "http://libplayer.geexbox.org/"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1+"
DEPENDS = "virtual/libx11 libxcb mplayer gstreamer"

INC_PR = "r1"

SRC_URI = "http://${PN}.geexbox.org/releases/${P}.tar.bz2;name=${PN}"

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
