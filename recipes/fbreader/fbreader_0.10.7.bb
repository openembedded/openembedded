DESCRIPTION = "FBreader is an ebook reader"
HOMEPAGE = "http://www.fbreader.org"
SECTION = "x11/utils"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "gtk+ enca expat bzip2 libgpewidget virtual/libiconv liblinebreak libfribidi"
PR = "r1"

SRC_URI = "http://www.fbreader.org/fbreader-sources-${PV}.tgz file://help.patch;patch=1"
	   
# Set the defaults
READER_RESOLUTION ?= "1024x600"
READER_ARCH       ?= "desktop"
READER_UI         ?= "gtk"
READER_STATUS	  ?= "release"

FILES_${PN} += "${datadir}/FBReader ${datadir}/zlibrary ${libdir}/zlibrary"

CFLAGS_append = " RESOLUTION=${READER_RESOLUTION} INSTALLDIR=${prefix}"
EXTRA_OEMAKE = "CC='${CXX}' LD='${CXX}' OE_CFLAGS='${CXXFLAGS}' INCPATH='${STAGING_INCDIR}' LIBPATH='${STAGING_LIBDIR}'"

inherit pkgconfig

do_configure() {
	cd ${WORKDIR}/${PN}-${PV}
	mv makefiles/target.mk makefiles/target.mk.orig
	
	echo "TARGET_ARCH = ${READER_ARCH}" > makefiles/target.mk	
	echo "UI_TYPE = ${READER_UI}" >> makefiles/target.mk
	echo "TARGET_STATUS = ${READER_STATUS}" >> makefiles/target.mk
}

do_install() {
        oe_runmake install DESTDIR=${D} RESOLUTION=${READER_RESOLUTION}
}
