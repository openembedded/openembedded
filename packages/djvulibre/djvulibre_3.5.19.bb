DESCRIPTION = "DjVuLibre is an open source (GPL'ed) implementation of DjVu, including viewers, browser plugins, decoders, simple encoders, and utilities."
LICENSE = "GPL"

DEPENDS = "jpeg libpng tiff"

SRC_URI = "http://downloads.sourceforge.net/djvu/djvulibre-${PV}.tar.gz \
           file://fix-cross-configure.patch;patch=1"


inherit qt4x11 autotools pkgconfig

#export QT_LIBS = "${OE_QMAKE_LIBS_QT}"
#export QT_CFLAGS = "${OE_QMAKE_CXXFLAGS} -I${QTDIR}/include/Qt/ "

EXTRA_OECONF = " --enable-threads \
                 --with-qt=${QTDIR} "

PACKAGES =+ "libdjvulibre"

FILES_libdjvulibre = "${libdir}/libdjvulibre.so.*"
FILES_${PN} += "${datadir}/djvu"

do_stage() {
        autotools_stage_all
}


