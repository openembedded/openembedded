require libpng.inc

PR = "r6"

SRC_URI += "file://makefile_fix.patch;patch=1"

do_stage() {
	cp libpng.pc libpng12.pc
	install -m 644 png.h ${STAGING_INCDIR}/png.h
	install -m 644 pngconf.h ${STAGING_INCDIR}/pngconf.h
	oe_libinstall -so libpng ${STAGING_LIBDIR}/
	oe_libinstall -so libpng12 ${STAGING_LIBDIR}/
	ln -sf libpng12.so ${STAGING_LIBDIR}/libpng.so
}
