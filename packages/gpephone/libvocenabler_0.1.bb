LICENSE     = "LiPS"
DESCRIPTION = "LiPS voice call  library."
SECTION     = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 dbus-glib linphone"
PR          = "r0"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpephone pkgconfig autotools

do_stage () {
	autotools_stage_all
}
