DESCRIPTION = "C++ bindings for the pango library."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "mm-common cairomm glibmm"
SHRT_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
PR = "r1"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/pangomm/${SHRT_VER}/pangomm-${PV}.tar.bz2"

inherit autotools flow-lossage

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${libdir}/*/include/"

EXTRA_OECONF = " --disable-documentation "

AUTOTOOLS_STAGE_PKGCONFIG = "1"

