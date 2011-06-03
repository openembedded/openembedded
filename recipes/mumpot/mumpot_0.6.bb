DESCRIPTION = "A map-viewer, simple editor and routing application for OSM maps"
HOMEPAGE = "http://www.mumpot.org/"
AUTHOR = "Andreas Kemnade"
SECTION = "x11/applications"
LICENSE = "GPLv3"
DEPENDS = "curl gtk+ bluez-libs bzip2 libxml2 libpng jpeg"

SRC_URI = "http://www.mumpot.org/download/mumpot-${PV}.tar.gz \
	file://mumpot-tah.desktop \
	file://mumpot-mapnik.desktop \
	file://mumpot-cyclemap.desktop"

inherit autotools pkgconfig

do_install_append() {
	install -d ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/mumpot-tah.desktop ${D}${datadir}/applications/mumpot-tah.desktop
	install -m 0644 ${WORKDIR}/mumpot-mapnik.desktop ${D}${datadir}/applications/mumpot-mapnik.desktop
	install -m 0644 ${WORKDIR}/mumpot-cyclemap.desktop ${D}${datadir}/applications/mumpot-cyclemap.desktop
}

SRC_URI[md5sum] = "9a0409c39e49c45cea3160c7ec7fe976"
SRC_URI[sha256sum] = "aa921664bcb15115796607cc34f83caaaf2280685be512bd8a9250a44ae83bd4"
