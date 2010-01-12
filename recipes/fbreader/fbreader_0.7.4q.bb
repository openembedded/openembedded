DESCRIPTION = "FBreader is an ebook reader"
LICENSE = "GPLv2"
HOMEPAGE = "http://only.mawhrin.net/fbreader/"
SECTION = "x11/utils"
PRIORITY = "optional"
DEPENDS = "gtk+ enca expat bzip2 libgpewidget"
PR = "r2"

SRC_URI = "http://only.mawhrin.net/fbreader/obsolete/fbreader-sources-${PV}.tgz \
	file://fbreader-0.7.4q_buildsys_oe.patch;patch=1"

FILES_${PN} += "${datadir}/FBReader ${datadir}/zlibrary"

CFLAGS_append = " RESOLUTION=240x320 INSTALLDIR=/usr"
EXTRA_OEMAKE = "CC='${CXX}' LD='${CXX}' OE_CFLAGS='${CXXFLAGS}' INCPATH='${STAGING_INCDIR}' LIBPATH='${STAGING_LIBDIR}'"

inherit pkgconfig

do_install () {
        cd fbreader/openzaurus; oe_runmake .builddir RESOLUTION=240x320
	cp -r data/* ${D}
}
