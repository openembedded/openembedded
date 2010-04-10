LICENSE     = "LGPL"
DESCRIPTION = "LiPS address book library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 librecord liblipsevent libim sqlite3"
PR          = "r1"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpephone pkgconfig autotools

LDFLAGS += " -L${STAGING_LIBDIR}"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "49fe67302fd76543a7574a73c01395ba"
SRC_URI[sha256sum] = "512674419ac2013d11eccf4f106d6cfc719c9c2b49215a8f0e89c5327d176a84"
