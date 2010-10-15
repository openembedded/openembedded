DESCRIPTION = "Libchamplain is a C library aimed to provide a Gtk+ widget to display rasterized maps. "
LICENSE = "LGPLv2.1"
DEPENDS = "cairo clutter clutter-gtk gtk+ libsoup-2.4"
PR = "r1"

inherit gnome autotools

FILES_${PN} += "${datadir}/champlain/error.svg"

PACKAGES =+ "${PN}-gtk"
RDEPENDS_${PN}-gtk = "clutter-gtk"
FILES_${PN}-gtk = "${libdir}/libchamplain-gtk*so.*"

SRC_URI[archive.md5sum] = "48bbaa2ab5b9b74c7dbffb81381e3020"
SRC_URI[archive.sha256sum] = "c1669cbfc0d1b01950d9740fd5d3f9f57cdfaf37df855392bdd214210d2f4601"
