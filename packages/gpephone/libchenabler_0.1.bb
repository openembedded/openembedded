LICENSE     = "LiPS"
DESCRIPTION = "LiPS voice call library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 sqlite3 librecord"
PR          = "r0"

GPE_TARBALL_SUFFIX = "gz"

inherit gpephone pkgconfig autotools

FILES_${PN} += " ${datadir}/vochistory"

do_stage () {
	autotools_stage_all
}
