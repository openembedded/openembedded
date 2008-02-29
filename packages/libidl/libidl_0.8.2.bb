SECTION = "x11/gnome/libs"
LICENSE = "LGPL"
SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libIDL/0.8/libIDL-0.8.2.tar.bz2"
S = "${WORKDIR}/libIDL-${PV}"

inherit autotools  pkgconfig

do_stage () {
	autotools_stage_all
}
