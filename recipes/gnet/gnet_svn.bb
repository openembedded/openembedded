DESCRIPTION = "GNet is a simple network library. It is written in C, object-oriented, and built upon GLib."
LICENSE = "LGPL"
SECTION = "libs/network"
HOMEPAGE = "http://www.gnetlibrary.org"
DEPENDS = "glib-2.0"
SRCREV = "495"
PV = "2.0.7+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.gnome.org/svn/${PN}/;module=trunk;proto=http \
           file://buildfix.patch \
           file://configure_fix.patch \
           file://pkgconfig_fix.patch "

S = "${WORKDIR}/trunk"

EXTRA_OECONF =	"--disable-pthreads"

FILES_${PN}-dev += "${libdir}/gnet-2.0"

inherit autotools pkgconfig
