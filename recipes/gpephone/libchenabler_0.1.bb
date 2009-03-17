LICENSE     = "LiPS"
DESCRIPTION = "LiPS voice call library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 sqlite3 librecord"
PR          = "r2"

GPE_TARBALL_SUFFIX = "gz"

inherit gpephone pkgconfig autotools

SRC_URI += "file://po.patch;patch=1"
FILES_${PN} += " ${datadir}/vochistory"

do_configure_prepend () {
	mkdir "${S}/po"
	touch "${S}/po/POTFILES.in"
}

do_stage () {
	autotools_stage_all
}
