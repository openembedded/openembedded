DESCRIPTION = "clxclient library from http://www.kokkinizita.net/linuxaudio/"
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "LGPLv2.1+"
PR = "r3"

DEPENDS = "libx11 clthreads freetype libxft"
RDEPENDS_${PN} = "libx11-locale"
TARGET_CC_ARCH += "-I ${STAGING_DIR_HOST}/usr/include/freetype2"
SRC_URI = "http://www.kokkinizita.net/linuxaudio/downloads/clxclient-${PV}.tar.bz2 \
	file://clxclient-Makefile.patch \
"

S = "${WORKDIR}/clxclient-${PV}"

inherit pkgconfig lib_package

do_compile() {
        unset CFLAGS CPPFLAGS CXXFLAGS
        oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
}
SRC_URI[md5sum] = "bd47f80a855d3203fcf10365e79d85e4"
SRC_URI[sha256sum] = "9de3e621d7acabb161b5926565a9c9373fedbc632222018f692346790149545d"
