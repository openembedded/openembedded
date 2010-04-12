LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r1"

inherit gnome

SRC_URI += "file://makefile.patch;patch=1"

DEPENDS = "gnome-vfs libbonobo"

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	oe_libinstall -C libgnome -a -so libgnome-2 ${STAGING_LIBDIR}
	gnome_stage_includes
}

SRC_URI[archive.md5sum] = "8fb8d073987cb4c5d9bfe577550d11c2"
SRC_URI[archive.sha256sum] = "eda475bdbc875fcb2c0b53acdb6de0f403bafc7941dd42f076353366d4f348b2"
