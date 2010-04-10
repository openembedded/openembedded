DESCRIPTION = "A uniform interface to video capture devices."
SECTION = "graphics"
LICENSE = "GPL"
DEPENDS = "intltool-native gtk+ libpng libxv"
PR = "r2"

SRC_URI = "http://www.unicap-imaging.org/downloads/unicap-${PV}.tar.gz \
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

SRC_URI[md5sum] = "69db7c7dacb58c303d44f3b6598653ee"
SRC_URI[sha256sum] = "bf619a4675aa4b7cec9c3a664e1fcd9d869facf393e4e9e51e52490db98d6585"
