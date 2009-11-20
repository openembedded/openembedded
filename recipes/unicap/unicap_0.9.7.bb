DESCRIPTION = "A uniform interface to video capture devices."
SECTION = "graphics"
LICENSE = "GPL"
DEPENDS = "intltool-native gtk+ libpng libxv"
PR = "r0"

SRC_URI = "http://www.unicap-imaging.org/downloads/unicap-${PV}.tar.gz"

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
