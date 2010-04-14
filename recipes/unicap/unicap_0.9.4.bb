DESCRIPTION = "A uniform interface to video capture devices."
SECTION = "graphics"
LICENSE = "GPL"
DEPENDS = "intltool-native gtk+ libpng libxv"
PR = "r0"

SRC_URI = "http://www.unicap-imaging.org/downloads/tisCMOS/unicap-${PV}.tar.gz \
           file://pkgconfig.patch;patch=1"

inherit autotools pkgconfig

do_stage () {
        autotools_stage_all
}

PACKAGES += "libucil unicapgtk"

FILES_${PN} = "${libdir}/libunicap.*so.* ${libdir}/unicap2/cpi/lib*.*so.*  ${libdir}/unicap2/cpi/lib*.*so"
FILES_${PN}-dev += " ${libdir}/unicap2/cpi/lib*.*a"
FILES_${PN}-dbg += " ${libdir}/unicap2/cpi/.debug"
FILES_libucil = "${libdir}/libucil*so.*"
FILES_libucil-dev = "${libdir}/libucil*.so ${libdir}/libucil*.*a"
FILES_unicapgtk = "${libdir}/libunicapgtk*so.*"
FILES_unicapgtk-dev = "${libdir}/libunicapgtk*so.* ${libdir}/libunicapgtk*.*a"

SRC_URI[md5sum] = "f4ef95b9338cc16754ab092a581d123c"
SRC_URI[sha256sum] = "63ba54255f6700777fa275a67585ec164952ecaa7f8de0c046b7ebc009363c7a"
