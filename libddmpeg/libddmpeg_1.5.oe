LICENSE = GPL
SECTION = "libs"
SRC_URI = "http://nchipin.kos.to/libddmpeg/libddmpeg_1.5.orig.tar.gz"

inherit autotools

do_stage() {
	autotools_stage_includes
	oe_libinstall -so -a -C src libddmpeg ${STAGING_LIBDIR}
}
