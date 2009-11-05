DESCRIPTION = "GPS Controlling Daemon"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "glib-2.0 dbus-glib bluez-libs libxslt-native"

inherit autotools pkgconfig

do_configure_prepend () {
	touch ${S}/gtk-doc.make
}

do_stage() {
	autotools_stage_all
}


PACKAGES += "libgypsy libgypsy-dev libgypsy-dbg"

FILES_lib${PN} = "${libdir}/lib*.so*"
FILES_lib${PN}-dev = "${includedir}/* ${libdir}/*.la ${libdir}/*.a ${libdir}/pkgconfig"
FILES_lib${PN}-dbg = "${libdir}/.debug"
FILES_${PN} = "${datadir}/dbus-1/services/ ${libexecdir}/gypsy-daemon ${sysconfdir}/dbus-1/system.d/*"
FILES_${PN}-dbg ="${libexecdir}/.debug*"
CONFFILES_${PN} = "${sysconfdir}/dbus-1/system.d/Gypsy.conf"
