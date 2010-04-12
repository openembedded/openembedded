DESCRIPTION = "Libchamplain is a C library aimed to provide a Gtk+ widget to display rasterized maps. "
LICENSE = "LGPL"
DEPENDS = "libchamplain clutter-gtk-0.8"

inherit gnome autotools_stage

SRC_URI = "http://libchamplain.pierlux.com/release/${PV}/libchamplain-gtk-${PV}.tar.gz"



SRC_URI[md5sum] = "c3e62c1912c0dba013c8f3df28fc809d"
SRC_URI[sha256sum] = "03d751bd836174e2d6766d8036fc72e130dd090b13256d40a58ba6ab659475ef"
