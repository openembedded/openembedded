LICENSE = "GPL"
SECTION = "libs"
PR = "r1"

DEPENDS= "libxml2 glib-2.0 zlib gtk-doc libbonobo gnome-vfs"

PACKAGES =+ "${PN}-gnome ${PN}-gnome-dev "

FILES_${PN}-gnome = "${libdir}/libgsf-gnome-1.so.*"
FILES_${PN}-gnome-dev = "${libdir}/libgsf-gnome-1.* ${includedir}/libgsf-1/gsf-gnome"

inherit autotools pkgconfig gnome


do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "0894afd88f9e43eada27e52cb22cd0f1"
SRC_URI[archive.sha256sum] = "ef7833047caf66ed3de7b0195223911d28e45c78617d25c6bd05a53fd6c30a0c"
