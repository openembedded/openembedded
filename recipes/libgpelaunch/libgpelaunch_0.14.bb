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

SRC_URI[md5sum] = "cac106e90f57753511a4436ca2cdbc3b"
SRC_URI[sha256sum] = "23425f74f304072f48d295e9d7168a6ecfb44c049074b34b71cfbf1f4d19ec85"
