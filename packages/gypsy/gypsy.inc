DESCRIPTION = "GPS Controlling Daemon"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "glib-2.0 dbus bluez-libs"

inherit autotools pkgconfig

do_configure_prepend () {
	touch ${S}/gtk-doc.make
}

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${datadir}/dbus-1/services/"
