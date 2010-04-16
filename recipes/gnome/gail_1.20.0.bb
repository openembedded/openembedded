LICENSE = "LGPL"
SECTION = "x11/libs"
PR = "r1"
DESCRIPTION = "GNOME Accessibility Implementation Library"
DEPENDS = "gtk+"
PROVIDES = "virtual/gail"

inherit gnome

EXTRA_OECONF = "--disable-gtk-doc"

FILES_${PN} += "${libdir}/gtk-2.0/modules/*.so"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/modules/.debug"

SRC_URI[archive.md5sum] = "697f83db831816946bb8944b8d34ec17"
SRC_URI[archive.sha256sum] = "2e547b33a1f0abffb1a9860e5dc09330fbf6fbb45b7fe90dc5d12cea5fbe829e"
