DESCRIPTION = "DjVuLibre is an open source (GPL'ed) implementation of DjVu, including viewers, browser plugins, decoders, simple encoders, and utilities."
LICENSE = "GPL"
SRC_URI = "http://downloads.sourceforge.net/djvu/djvulibre-${PV}.tar.gz"

DEPENDS = "jpeg libpng tiff"

inherit autotools pkgconfig

PACKAGES =+ "libdjvulibre"

FILES_libdjvulibre = "${libdir}/libdjvulibre.so.*"
FILES_${PN} += "${datadir}/djvu"



