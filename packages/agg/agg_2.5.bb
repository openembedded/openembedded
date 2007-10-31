DESCRIPTION = "Anti Grain Geometry - A High Quality Rendering Engine for C++"
AUTHOR = "mcseem@antigrain.com"
HOMEPAGE = "http://www.antigrain.com"
SECTION = "libs"
LICENSE = "AGG License"
DEPENDS = "virtual/libx11 virtual/libsdl freetype"

PR = "r0"

SRC_URI = "http://www.antigrain.com/${P}.tar.gz"

S = "${WORKDIR}/${P}"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-sdl-exec-prefix=${STAGING_DIR_NATIVE}${layout_exec_prefix}"
CFLAGS += " -I{$STAGING_INCDIR} "

PACKAGES =+ "${PN}-sdl ${PN}-x11"

FILES_${PN}-sdl = "${libdir}/libaggplatformsdl.so.*"
FILES_${PN}-x11 += "${libdir}/libaggplatformX11.so.*"
FILES_${PN} = "${libdir}/libagg.so.* \
               ${libdir}/libaggfontfreetype.so.*"

LEAD_SONAME = "libagg.so"

do_stage() {
        install -m 0644 libagg.m4 ${STAGING_DATADIR}/aclocal/
        install -d ${STAGING_INCDIR}/agg2
        cd include
        headers=`find . -name "*.h"`
        for f in $headers
        do
                install -m 0644 $f ${STAGING_INCDIR}/agg2/
        done
}



