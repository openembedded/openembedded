DESCRIPTION = "DjVuLibre is an open source (GPL'ed) implementation of DjVu, including viewers, browser plugins, decoders, simple encoders, and utilities."
LICENSE = "GPL"
DEPENDS = "jpeg libpng tiff"

SRC_URI = "${SOURCEFORGE_MIRROR}/djvu/djvulibre-${PV}.tar.gz \
           file://fix-cross-configure.patch;patch=1"

inherit qt4x11 autotools pkgconfig

#export QT_LIBS = "${OE_QMAKE_LIBS_QT}"
#export QT_CFLAGS = "${OE_QMAKE_CXXFLAGS} -I${QTDIR}/include/Qt/ "

EXTRA_OECONF = " --enable-threads \
                 --with-qt=${QTDIR} "

do_configure() {
	gnu-configize
	autoreconf
	oe_runconf
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e s:-L/usr/lib::g $i
	done
}

do_stage() {
        autotools_stage_all
}

PACKAGES =+ "libdjvulibre"
FILES_libdjvulibre = "${libdir}/libdjvulibre.so.*"
FILES_${PN} += "${datadir}/djvu"

SRC_URI[md5sum] = "4c6f3eb03ffbd067b6d2fe2344b0d9ad"
SRC_URI[sha256sum] = "39f80c1810be22c5ea7f6a44bbb449c3e29902895dcff9da6a8440891a67b8b4"
