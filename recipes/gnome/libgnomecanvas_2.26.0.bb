LICENSE = "GPL"
SECTION = "x11/gnome/libs"
DESCRIPTION = "A powerful object-oriented display"

inherit gnome

DEPENDS = "libglade libart-lgpl virtual/gail"

EXTRA_OECONF = "--disable-gtk-doc"

FILES_${PN} += "${libdir}/libglade/*/libcanvas.so"
FILES_${PN}-dbg += "${libdir}/libglade/*/.debug/"
FILES_${PN}-dev += "${libdir}/libglade/*/libcanvas.*a"

do_configure_prepend() {
    sed -i -e s:docs::g ${S}/Makefile.am
}

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "9bbc635e5ae70e63af071af74ba7e72f"
SRC_URI[archive.sha256sum] = "80b480acc33d7303f651e9c5bc8fea51c9e9a9ed59ebfdbbb730dd798bcbc58d"
