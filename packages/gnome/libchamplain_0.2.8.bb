DESCRIPTION = "Libchamplain is a C library aimed to provide a Gtk+ widget to display rasterized maps. "
LICENSE = "LGPL"
DEPENDS = "clutter-cairo libsoup-2.4 clutter gtk+"

inherit gnome autotools_stage

SRC_URI = "http://libchamplain.pierlux.com/release/${PV}/libchamplain-${PV}.tar.gz"

FILES_${PN} += "${datadir}/champlain/error.svg"

