LICENSE     = "LiPS"
DESCRIPTION = "LiPS address book library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 librecord2 gconf sqlite3"
PR          = "r1"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

SRC_URI += "file://i18n.patch;patch=1"

FILES_${PN} += "${datadir}/contact ${libdir}/lips/*.so"
FILES_${PN}-dbg += "${libdir}/lips/.debug/*.so"

do_configure_prepend () {
        mkdir "${S}/po"
        touch "${S}/po/POTFILES.in"
}

do_stage () {
	autotools_stage_all
}
