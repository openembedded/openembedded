DESCRIPTION = "FBreader is an ebook reader"
LICENSE = "GPLv2"
HOMEPAGE = "http://only.mawhrin.net/fbreader/"
SECTION = "x11/utils"
PRIORITY = "optional"
DEPENDS = "gtk+ enca expat bzip2"
PR = "r2"

SRC_URI = "http://only.mawhrin.net/fbreader/obsolete/fbreader-sources-${PV}.tgz \
	file://fbreader-0.7.3d_buildsys_oe.patch;patch=1"

FILES_${PN} += "${datadir}/FBReader"

CFLAGS_append = " RESOLUTION=240x320 INSTALLDIR=/usr"

inherit autotools pkgconfig

do_install_append() {
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/${PN}-${PV}/fbreader/openzaurus/gpe/fbreader.desktop ${D}${datadir}/applications/fbreader.desktop
	install -m 0644 ${WORKDIR}/${PN}-${PV}/fbreader/icons/34x28/FBReader.png ${D}${datadir}/pixmaps/fbreader.png
}
