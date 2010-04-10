DESCRIPTION = "Libnice is an implementation of the IETF's draft Interactice Connectivity Establishment standard (ICE)."
HOMEPAGE = "http://nice.freedesktop.org/wiki/"
SRC_URI = "http://nice.freedesktop.org/releases/libnice-${PV}.tar.gz"

LICENSE = "LGPL/MPL"
DEPENDS = "glib-2.0 gstreamer"

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*a"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

do_compile_append() {
        for i in $(find ${S} -name "*.pc") ; do
            sed -i -e s:${STAGING_DIR_TARGET}::g \
                   -e s:/${TARGET_SYS}::g \
                      $i
        done
}



SRC_URI[md5sum] = "055e3eedf735ee1257fd4bb9ce86d04e"
SRC_URI[sha256sum] = "adf3612367456328609c65ecc39c9bb08c0fef84cebbd1a3b5fcfe5e9614ac82"
