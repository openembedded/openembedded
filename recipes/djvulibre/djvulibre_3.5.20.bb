DESCRIPTION = "DjVuLibre is an open source (GPL'ed) implementation of DjVu, including viewers, browser plugins, decoders, simple encoders, and utilities."
LICENSE = "GPL"
DEPENDS = "jpeg libpng tiff"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/djvu/djvulibre-${PV}.tar.gz \
           file://fix-cross-configure.patch;patch=1"

inherit qt4x11 autotools pkgconfig

#export QT_LIBS = "${OE_QMAKE_LIBS_QT}"
#export QT_CFLAGS = "${OE_QMAKE_CXXFLAGS} -I${QTDIR}/include/Qt/ "

EXTRA_OECONF = " --enable-threads \
                 --with-qt=${PAMLTOPDIR} "

do_stage() {
        autotools_stage_all
}

PACKAGES =+ "libdjvulibre"
FILES_libdjvulibre = "${libdir}/libdjvulibre.so.*"
FILES_${PN} += "${datadir}/djvu"

SRC_URI[md5sum] = "c94091de014b3aaf037d3d0f398d36c2"
SRC_URI[sha256sum] = "d937528e10c16831d8df31893ee24da8ec2bfd9e9170671c482a1b1abfc5efc3"
