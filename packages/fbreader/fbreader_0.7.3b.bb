DESCRIPTION = "FBreader is an ebook reader"
LICENSE = "GPL2"
HOMEPAGE = "http://only.mawhrin.net/fbreader/"
SECTION = "x11/utils"
PRIORITY = "optional"
DEPENDS = "gtk+ enca expat"
MAINTAINER = "John Bloom <johnxx@gmail.com>"

SRC_URI = "http://only.mawhrin.net/fbreader/fbreader-sources-${PV}.tgz \
	file://hack-makefile.patch;patch=1 \
	file://set-target.patch;patch=1 \
	file://change-desktop.patch;patch=1"

FILES_${PN} += "/usr/share/FBReader"

inherit autotools pkgconfig

do_install_append() {
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/${PN}-${PV}/fbreader/pdaxrom/usr/share/applications/FBReader.desktop ${D}${datadir}/applications/fbreader.desktop
	install -m 0644 ${WORKDIR}/${PN}-${PV}/fbreader/icons/34x28/FBReader.png ${D}${datadir}/pixmaps/fbreader.png
}
