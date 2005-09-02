DESCRIPTION = "A graphic library for file loading, saving, rendering, and manipulation."
LICENSE = "BSD"
# can also depend on tiff34, ungif or gif, z, bz2, id3tag
DEPENDS = "freetype libpng jpeg"
PROVIDES += "virtual/imlib2"

inherit efl

SRC_URI = "http://enlightenment.freedesktop.org/files/imlib2-${PV}.tar.gz"
S = "${WORKDIR}/imlib2-${PV}"

libraries = ""
headers = ""

do_stage_append() {
        oe_libinstall -C src/lib libImlib2 ${STAGING_LIBDIR}/
        install -m 0644 ${S}/src/lib/Imlib2.h ${STAGING_INCDIR}/

        install -d ${STAGING_LIBDIR}/imlib2/loaders
        for i in src/modules/loaders/.libs/*.so
        do
                install -m 0755 $i ${STAGING_LIBDIR}/imlib2/loaders
        done

        install -d ${STAGING_LIBDIR}/imlib2/filters
        for i in src/modules/filters/.libs/*.so
        do
                install -m 0755 $i ${STAGING_LIBDIR}/imlib2/filters
        done
}

do_install() {
        oe_libinstall -C src/lib libImlib2 ${D}${libdir}/
        install -m 0644 ${S}/src/lib/Imlib2.h ${D}${incdir}/

        install -d ${D}${libdir}/imlib2/loaders
        for i in src/modules/loaders/.libs/*.so
        do
                install -m 0755 $i ${D}${libdir}/imlib2/loaders
        done

        install -d ${D}${libdir}/imlib2/filters
        for i in src/modules/filters/.libs/*.so
        do
                install -m 0755 $i ${D}${libdir}/imlib2/filters
        done
}

PACKAGES =+ "imlib2-loaders imlib2-filters"
FILES_${PN} = "${libdir}/lib*.so.* ${libdir}/imlib2"
FILES_${PN}-dev += "${bindir}/imlib2-config"
FILES_imlib2-bin = "${bindir}"
FILES_imlib2-loaders = "${libdir}/imlib2/loaders/*.so"
FILES_imlib2-filters = "${libdir}/imlib2/filters/*.so"
