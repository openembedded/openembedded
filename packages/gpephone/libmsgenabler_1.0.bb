LICENSE     = "LiPS"
DESCRIPTION = "LiPS event model library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 dbus-glib librecord sqlite3"
PR          = "r0"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpephone pkgconfig autotools

do_stage () {
	autotools_stage_all
}
