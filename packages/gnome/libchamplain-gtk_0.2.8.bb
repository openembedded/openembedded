DESCRIPTION = "Libchamplain is a C library aimed to provide a Gtk+ widget to display rasterized maps. "
LICENSE = "LGPL"
DEPENDS = "libchamplain clutter-gtk-0.8"

inherit gnome autotools_stage

SRC_URI = "http://libchamplain.pierlux.com/release/${PV}/libchamplain-gtk-${PV}.tar.gz"


