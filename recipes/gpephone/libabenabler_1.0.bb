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
