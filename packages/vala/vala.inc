DESCRIPTION = "Vala is a C#-like language dedicated to ease GObject programming. \
Vala compiles to plain C and has no runtime environment nor penality whatsoever."
SECTION = "devel"
DEPENDS = "glib-2.0 dbus"
HOMEPAGE = "http://live.gnome.org/Vala"
LICENSE = "LGPL"

S = "${WORKDIR}/vala-${PV}"

inherit autotools lib_package

do_stage() {
	autotools_stage_all
}

FILES_${PN}-doc += ${datadir}/devhelp
