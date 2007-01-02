LICENSE = "LGPL"
DESCRIPTION = "GPE program launcher library"
SECTION = "libs"
DEPENDS = "gtk+ startup-notification"
PR = "r1"

inherit autotools pkgconfig

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"


FILES_${PN}-dbg += "/usr/libexec/libgpelaunch/.debug"

do_stage() {
	autotools_stage_all
}
