DESCRIPTION = "C++ bindings for the pango library."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "cairomm glibmm"
SHRT_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/pangomm/${SHRT_VER}/pangomm-${PV}.tar.bz2"

inherit autotools flow-lossage

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${libdir}/*/include/"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "85be0a654ed521e5594f64efdb3fa7d8"
SRC_URI[sha256sum] = "211a0092cfd50923eaad75c20630c0a1818e56605d4b6fbc10702d5a34ea7107"
