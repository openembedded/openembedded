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

SRC_URI[md5sum] = "866fd13611a8de946428db1df9be8468"
SRC_URI[sha256sum] = "74def55ba6a61e966e0873a4081fd3dd65089b94b837810d3bc056221d7e41c7"
