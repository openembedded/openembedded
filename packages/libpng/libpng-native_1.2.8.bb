include libpng_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libpng-${PV}"
DEPENDS = "zlib-native"

do_stage() {
        cp libpng.pc libpng12.pc
        install -m 644 png.h ${STAGING_INCDIR}/png.h
        install -m 644 pngconf.h ${STAGING_INCDIR}/pngconf.h
        oe_libinstall -so libpng12 ${STAGING_LIBDIR}/
        ln -sf libpng12.so ${STAGING_LIBDIR}/libpng.so
}
