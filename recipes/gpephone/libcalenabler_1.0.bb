LICENSE     = "LiPS"
DESCRIPTION = "LiPS calendar database backend library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
PR          = "r1"
DEPENDS     = "glib-2.0 util-linux-ng sqlite3"

GPE_TARBALL_SUFFIX = "gz"

inherit gpephone pkgconfig autotools

LDFLAGS += " -L${STAGING_LIBDIR}"

do_stage () {
	autotools_stage_all
}
