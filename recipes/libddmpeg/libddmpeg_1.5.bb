LICENSE = "GPL"
SECTION = "libs"
SRC_URI = "http://nchipin.kos.to/libddmpeg/libddmpeg_1.5.orig.tar.gz"

inherit autotools

do_stage() {
	autotools_stage_includes
	oe_libinstall -so -a -C src libddmpeg ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "89e59638d31384987d912741986398b6"
SRC_URI[sha256sum] = "9422e73c55aa921fbbce06e5e01bba0b98bb7a0f1640c27cfd307c290dba792c"
