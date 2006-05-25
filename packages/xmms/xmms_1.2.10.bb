DESCRIPTION = "The X MultiMedia System"
HOMEPAGE = "http://www.xmms.org/"
LICENSE = "GPL"
SECTION = "x11/multimedia"
# TODO add esd mikmod vorbis
DEPENDS = "gtk+-1.2"

SRC_URI = "http://www.xmms.org/files/1.2.x/xmms-${PV}.tar.bz2 \
           file://gcc4.patch;patch=1"

inherit autotools

# TODO enable esd mikmod vorbis
EXTRA_OECONF = "--disable-opengl --disable-esd --disable-mikmod --disable-vorbis"

do_configure() {
	oe_runconf
}

do_compile() {
	oe_runmake LIBTOOL=${STAGING_BINDIR}/${TARGET_PREFIX}libtool
}

