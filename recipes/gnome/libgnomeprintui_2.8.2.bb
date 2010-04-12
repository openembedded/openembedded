LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r1"
DEPENDS = "libgnomeprint gtk+ libgnomecanvas gnome-icon-theme gnome-common"

inherit gnome pkgconfig

SRC_URI += "file://configure.patch;patch=1"

do_stage() {
	install -d ${STAGING_LIBDIR}
	oe_libinstall -so -a -C libgnomeprintui libgnomeprintui-2-2 ${STAGING_LIBDIR}
	gnome_stage_includes
}

SRC_URI[archive.md5sum] = "b38d1f6813dd52879ba4174ddc3f1b1c"
SRC_URI[archive.sha256sum] = "5c4ba52ca52cdb2d89e2fb7a638891ded38e844c08dd992e482f0793cfbc71c7"
