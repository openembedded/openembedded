DESCRIPTION = "Libchamplain is a C library aimed to provide a Gtk+ widget to display rasterized maps. "
LICENSE = "LGPL"
DEPENDS = "clutter-cairo libsoup-2.4 clutter gtk+"

inherit gnome autotools_stage

SRC_URI = "http://libchamplain.pierlux.com/release/${PV}/libchamplain-${PV}.tar.gz"

FILES_${PN} += "${datadir}/champlain/error.svg"


SRC_URI[md5sum] = "fa4a620efa1a1c1036b6701b7d4dafe1"
SRC_URI[sha256sum] = "01e17811a85e93e5158f5d721b9b1b249db44683735a172fa0debd9759d3175c"
