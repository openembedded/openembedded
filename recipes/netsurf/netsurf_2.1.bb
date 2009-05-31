DESCRIPTION = "Lightweight web browser capable of handling many of the \
web standards in use today."
HOMEPAGE = "http://www.netsurf-browser.org/"
SECTION = "x11/network"
LICENSE = "GPLv2"

SRC_URI = "http://www.netsurf-browser.org/downloads/releases/netsurf-${PV}-src.tar.gz \
	   file://fix_makefile.patch;patch=1 \
	   file://debugxml_fix.patch;patch=1 \
	   file://netsurf.png \
	   file://netsurf.desktop \
	   file://Makefile.config"

# Workaround for 2.1 tarball (unpacks into netsurf/, not netsurf-2.1/ )
S = "${WORKDIR}/netsurf"

DEPENDS = "gtk+ lemon-native re2c-native jpeg openssl curl libxml2 \
	   libglade hubbub libnsgif libnsbmp lcms"

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix}"

do_configure() {
	cp ${WORKDIR}/Makefile.config ${S}/
}

do_install() {
	oe_runmake install
	install -d ${D}/${datadir}/applications
	install -d ${D}/${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/netsurf.png ${D}/${datadir}/pixmaps/
	install -m 0644 ${WORKDIR}/netsurf.desktop ${D}/${datadir}/applications/
}
