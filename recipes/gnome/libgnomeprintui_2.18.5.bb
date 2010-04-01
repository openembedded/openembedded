LICENSE = "GPL"
SECTION = "x11/gnome/libs"
DEPENDS = "libgnomeprint gtk+ libgnomecanvas gnome-icon-theme"

inherit gnome pkgconfig

SRC_URI[archive.md5sum] = "66c1cf3a9ead428585c2c44e6110ebb7"
SRC_URI[archive.sha256sum] = "48ef73621dc2d208f81031dc87d18757879761ca176df80f46fafcfd9af9449f"

EXTRA_OECONF = "use_local_libgnomeprint_la=no"

