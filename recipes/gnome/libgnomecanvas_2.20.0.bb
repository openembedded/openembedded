LICENSE = "GPL"
SECTION = "x11/gnome/libs"
DESCRIPTION = "A powerful object-oriented display"
PR = "r2"

inherit gnome

DEPENDS = "libglade libart-lgpl virtual/gail"

EXTRA_OECONF = "--disable-gtk-doc"

FILES_${PN} += "${libdir}/libglade/*/libcanvas.so"
FILES_${PN}-dbg += "${libdir}/libglade/*/.debug/"
FILES_${PN}-dev += "${libdir}/libglade/*/libcanvas.*a"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "109b71b02e0c976d65b46129d0ad69d1"
SRC_URI[archive.sha256sum] = "c1d7301ecea3719e307182222ba19375b74017580d58e4a25f4ae15c8c8f9c3f"
