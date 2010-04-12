LICENSE = "LGPL"
DEPENDS = "glib-2.0"

inherit gnome lib_package

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "f0e3584b9157d3425184a9e21e3ac482"
SRC_URI[archive.sha256sum] = "af9643abf15887c9cb501a4dcc6f432ec0896b7087ef8739526f284ed1461a18"
