DESCRIPTION = "Anti Grain Geometry - A High Quality Rendering Engine for C++"
AUTHOR = "mcseem@antigrain.com"
HOMEPAGE = "http://www.antigrain.com"
SECTION = "libs"
LICENSE = "AGG License"
DEPENDS = "freetype"

PR = "r0"

SRC_URI = "http://www.antigrain.com/agg-${PV}.tar.gz"
SRC_URI += "http://www.wxsvg.org/files/agg-2.5_cygming.patch;patch=1"
S = "${WORKDIR}/agg-${PV}"

inherit autotools pkgconfig

CFLAGS += " -I{$STAGING_INCDIR} "

FILES_${PN} = "${libdir}/libagg.so.* \
               ${libdir}/libaggfontfreetype.so.*"

LEAD_SONAME = "libagg.so"

EXTRA_OECONF = "--disable-gpc --without-x --disable-examples --disable-ctrl \
--disable-platform --disable-win32tt --disable-sdltest"

do_stage() {
    oe_libinstall -a -so libagg ${STAGING_LIBDIR}
    oe_libinstall -a -so libaggfontfreetype ${STAGING_LIBDIR}
    install -m 0644 libagg.m4 ${STAGING_DATADIR}/aclocal/
    install -d ${STAGING_INCDIR}/agg2

    for f in font_freetype font_win32_tt gpc
    do
            install -m 0644 ${S}/$f/*.h ${STAGING_INCDIR}/agg2/
    done

    cd include
    headers=`find . -name "*.h"`
    for f in $headers
    do
            install -D -m 0644 $f ${STAGING_INCDIR}/agg2/$f
    done
}
