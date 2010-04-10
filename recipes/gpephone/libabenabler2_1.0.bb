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

SRC_URI[md5sum] = "6bb28fc35f7589b8fae2ed73f9e5e08e"
SRC_URI[sha256sum] = "901eb2cd2b817f70ee400565f714ee95b3ebed692ba37a579b6d71a21dab1a43"
