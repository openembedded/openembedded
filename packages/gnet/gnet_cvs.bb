DESCRIPTION = "GNet is a simple network library. It is written in C, object-oriented, and built upon GLib."
LICENSE = "LGPL"
SECTION = "libs/network"
HOMEPAGE = "http://www.gnetlibrary.org"
DEPENDS = "glib-2.0"
PV = "2.0.7+cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=gnet \
           file://buildfix.patch;patch=1"
S = "${WORKDIR}/gnet"

EXTRA_OECONF =	"--disable-pthreads"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
