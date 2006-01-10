LICENSE = "LGPL"
DESCRIPTION = "Library for parsing CORBA IDL files"
SECTION = "gnome/libs"
DEPENDS = "glib-2.0"
PR = "r1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/libIDL/0.8/libIDL-${PV}.tar.bz2"
S = "${WORKDIR}/libIDL-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

FILES_${PN} = "${libdir}/*.so.*"
FILES_${PN}-dev += " ${bindir}" 
