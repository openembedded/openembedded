LICENSE     = "LiPS"
DESCRIPTION = "LiPS message backend library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 dbus-glib librecord sqlite3"
PR          = "r2"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpephone pkgconfig autotools

FILES_${PN} += "$(datadir)/libmsgenabler"

do_stage () {
	autotools_stage_all
}
