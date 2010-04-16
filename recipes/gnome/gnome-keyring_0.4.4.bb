LICENSE = "GPL"
SECTION = "x11/gnome"
SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/${PN}/0.4/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

DEPENDS = "gtk+"

EXTRA_OECONF = "--disable-gtk-doc"

SRC_URI[md5sum] = "dc17fa8b04172d3b1993caa6959a7648"
SRC_URI[sha256sum] = "f6799acf59bc91054c4832e7956cb3126effdf911f746139478dcfa8ec727653"
