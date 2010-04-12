LICENSE = "GPL"
SECTION = "x11/gnome/libs"
DEPENDS = "libgnomeprint gtk+ libgnomecanvas gnome-icon-theme"
PR = "r1"

inherit gnome pkgconfig

EXTRA_OECONF = "use_local_libgnomeprint_la=no"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "f2c5796f15d6b6701bfa224d856098ce"
SRC_URI[archive.sha256sum] = "4f7c75e54474a76eff41b6e3da15afadd2d5207a04bc82d85b728395563cf747"
