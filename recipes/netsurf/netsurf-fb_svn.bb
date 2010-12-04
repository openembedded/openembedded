DESCRIPTION = "NetSurf is a lightweight, multi-platform web browser."
HOMEPAGE = "http://www.netsurf-browser.org/"
SECTION = "x11/network"
LICENSE = "GPLv2"
SRCREV = "10950"
PV = "2.6+svnr${SRCPV}"
PR = "r1"

DEPENDS = "virtual/libsdl lemon-native re2c-native jpeg openssl curl \
	   libxml2 hubbub libcss libnsfb libnsgif libnsbmp lcms"

RDEPENDS_${PN} = "ttf-dejavu-sans ttf-dejavu-serif ttf-dejavu-sans-mono"

SRC_URI = "svn://svn.netsurf-browser.org/trunk;module=netsurf \
	   file://fix_makefile.patch \
	   file://debugxml_fix.patch \
	   file://Makefile.config"

S = "${WORKDIR}/netsurf"

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix}"

FILES_${PN} += " /usr/share/netsurf "

do_configure() {
	cp ${WORKDIR}/Makefile.config ${S}/
}

do_compile() {
}

do_install() {
	oe_runmake TARGET=framebuffer install
}
