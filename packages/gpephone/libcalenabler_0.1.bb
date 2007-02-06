LICENSE     = "LiPS"
DESCRIPTION = "LiPS event model library."
SECTION     = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 e2fsprogs-libs sqlite3"
PR          = "r1"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe pkgconfig autotools

LDFLAGS += " -L${STAGING_LIBDIR}"

do_stage () {
	autotools_stage_all
}
