LICENSE = "GPL"
SECTION = "libs"
PR = "r1"

DEPENDS= "libxml2 glib-2.0 zlib gtk-doc libbonobo gnome-vfs"
RDEPENDS = "gconf gnome-vfs"


PACKAGES =+ "${PN}-gnome ${PN}-gnome-dev "

FILES_${PN}-gnome = "${libdir}/libgsf-gnome-1.so.*"
FILES_${PN}-gnome-dev = "${libdir}/libgsf-gnome-1.* ${includedir}/libgsf-1/gsf-gnome"

inherit autotools pkgconfig gnome


do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "b35e95f6bd7b8add9981b6cf6336674a"
SRC_URI[archive.sha256sum] = "458e7b2ca26f0d212f91b445f0a93db62a679ec671bd3cc980f3c1ac65f06b96"
