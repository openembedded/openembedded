DESCRIPTION = "2D barcode scanner toolkit."
SECTION = "graphics"
LICENSE = "GPL"
DEPENDS = "intltool-native gtk+ libpng jpeg"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.bz2"

inherit autotools pkgconfig

EXTRA_OECONF = " --without-imagemagick --without-qt --without-python"

PACKAGES += "libzbar libzbargtk"

FILES_${PN} = "${bindir}/zbar*"
FILES_${PN}-doc = "${datadir}/doc ${datadir}/man "
FILES_${PN}-dbg += " ${bindir}/.debug"
FILES_libzbar = "${libdir}/libzbar.so.*"
FILES_libzbar-dev = "${libdir}/libzbar.so ${libdir}/libzbar.*a ${includedir}/zbar* "
FILES_libzbargtk = "${libdir}/libzbargtk.so.*"
FILES_libzbargtk-dev = "${libdir}/libzbargtk.so ${libdir}/libzbargtk.*a"

SRC_URI[md5sum] = "b5b0efd92af16230ce9952e7a9a671fd"
SRC_URI[sha256sum] = "5415ffde882c7f7acee58e8a36aa65e732cfcfbbb582669480d6cf9549edfbbc"
