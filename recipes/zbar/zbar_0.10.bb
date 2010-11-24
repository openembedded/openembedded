DESCRIPTION = "2D barcode scanner toolkit."
SECTION = "graphics"
LICENSE = "GPL"
DEPENDS = "intltool-native gtk+ libpng jpeg"
PR = "r0"

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

SRC_URI[md5sum] = "0fd61eb590ac1bab62a77913c8b086a5"
SRC_URI[sha256sum] = "234efb39dbbe5cef4189cc76f37afbe3cfcfb45ae52493bfe8e191318bdbadc6"
