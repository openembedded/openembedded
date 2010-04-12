LICENSE = "GPL"
SECTION = "x11/gnome/libs"

DEPENDS = "libxml2 libgnomecups glib-2.0 pango libart-lgpl fontconfig popt gnome-common"

inherit flow-lossage pkgconfig gnome

FILES_${PN}-dbg += "${libdir}/libgnomeprint/${PV}/modules/transports/.debug \
		    ${libdir}/libgnomeprint/${PV}/modules/.debug  ${libdir}/libgnomeprint/${PV}/modules/*/.debug"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "c325baf4487335259e050619185787b1"
SRC_URI[archive.sha256sum] = "0ead99d6e227192d09902bdb37ec6aac25555a453ff4c338b49700fc477070c5"
