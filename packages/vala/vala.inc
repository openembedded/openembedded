DESCRIPTION = "Vala is a C#-like language dedicated to ease GObject programming. \
Vala compiles to plain C and has no runtime environment nor penality whatsoever."
SECTION = "devel"
DEPENDS = "glib-2.0 dbus"
HOMEPAGE = "http://live.gnome.org/Vala"
LICENSE = "LGPL"

MAJV = "${@bb.data.getVar('PV',d,1)[:3]}"

SRC_URI = "http://download.gnome.org/sources/vala/${MAJV}/vala-${PV}.tar.bz2"
S = "${WORKDIR}/vala-${PV}"

inherit autotools lib_package

EXTRA_OECONF = "--enable-vapigen"

do_stage() {
	autotools_stage_all
}

FILES_${PN}-doc += ${datadir}/devhelp
