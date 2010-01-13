DESCRIPTION = "FBreader is an ebook reader"
HOMEPAGE = "http://www.fbreader.org"
SECTION = "x11/utils"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "gtk+ enca expat bzip2 libgpewidget virtual/libiconv"
PR = "r7"

# The RESOLUTION is defined at compile time which makes
# this package MACHINE specific.
PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"

SRC_URI = "http://www.fbreader.org/obsolete/fbreader-sources-${PV}.tgz \
	   file://fbreader-0.8.2a_buildsys_oe.patch;patch=1 \
	   file://480x640-buildfix.patch;patch=1"
	   
SRC_URI_append_spitz = "\
		  file://zaurus-VGA.patch;patch=1"

SRC_URI_append_akita = "\
		  file://zaurus-VGA.patch;patch=1"

SRC_URI_append_htcuniversal = "\
		  file://zaurus-VGA.patch;patch=1"

# Set the defaults
READER_RESOLUTION = "240x320"
READER_ARCH	  = "openzaurus"
READER_GUI	  = "gpe"
READER_STATUS	  = "release"

# Set device specific overrides
READER_RESOLUTION_om-gta01 = "480x640"
READER_RESOLUTION_spitz = "640x480"
READER_RESOLUTION_akita = "640x480"
READER_RESOLUTION_htcuniversal = "640x480"

FILES_${PN} += "${datadir}/FBReader ${datadir}/zlibrary"

CFLAGS_append = " RESOLUTION=${READER_RESOLUTION} INSTALLDIR=/usr"
EXTRA_OEMAKE = "CC='${CXX}' LD='${CXX}' OE_CFLAGS='${CXXFLAGS}' INCPATH='${STAGING_INCDIR}' LIBPATH='${STAGING_LIBDIR}'"

inherit pkgconfig

do_configure() {
	cd ${WORKDIR}/${PN}-${PV}
	mv makefiles/target.mk makefiles/target.mk.orig
	
	echo "TARGET_ARCH = ${READER_ARCH}" > makefiles/target.mk	
	echo "UI_TYPE = ${READER_GUI}" >> makefiles/target.mk
	echo "TARGET_STATUS = ${READER_STATUS}" >> makefiles/target.mk
	
	cd fbreader/data/help
	
	# FIXME: Add native _480x640 file with propper linebreaks
	ln -s MiniHelp.240x320.fb2 MiniHelp.openzaurus_480x640.fb2
}

do_install () {
        cd fbreader/${READER_ARCH}; oe_runmake .builddir RESOLUTION=${READER_RESOLUTION}
	cp -r data/* ${D}
}
