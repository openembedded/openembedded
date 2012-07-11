DESCRIPTION = "Lightweight web browser capable of handling many of the \
web standards in use today."
HOMEPAGE = "http://www.netsurf-browser.org/"
SECTION = "x11/network"
LICENSE = "GPLv2"

SRC_URI = "http://download.netsurf-browser.org/netsurf/releases/source/netsurf-${PV}-src.tar.gz \
	   file://fix_makefile.patch \
	   file://debugxml_fix.patch \
	   file://netsurf.png \
	   file://netsurf.desktop \
	   file://Makefile.config"

PR = "r1"

# Workaround for 2.6 tarball (unpacks into netsurf/, not netsurf-2.6/ )
S = "${WORKDIR}/netsurf"

DEPENDS = "gtk+ lemon-native re2c-native jpeg openssl curl libxml2 \
	   libglade hubbub libcss libnsgif libnsbmp lcms"

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

SRC_URI[md5sum] = "8653789d2ede6dbbfe79882afc7538fc"
SRC_URI[sha256sum] = "366ad15e1879776b54882fd6f3fa4e421a049644c029e4c14fc163b76c6fc190"
