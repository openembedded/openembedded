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

SRC_URI[md5sum] = "1264bd213c631d29d1b4bc04696de66a"
SRC_URI[sha256sum] = "0f34656e262d7c41c1499dbe1aa3bc91c1fe8dc230ab79d5cf027ab6d141ee56"
