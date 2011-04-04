DESCRIPTION = "GNOME bluetooth manager"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gnome-doc-utils-native obexd obex-data-server gconf gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring libx11 libxi"

inherit gnome

SRC_URI[archive.md5sum] = "f129686fe46c4c98eb70a0cc85d59cae"
SRC_URI[archive.sha256sum] = "57b1f06c96a1b85e1c19ff919d708cc38e95edae658881ed99968c325839a973"

# No 'nautilus-sendto' recipe in OE yet
EXTRA_OECONF += "--enable-nautilus-sendto=no"

# No native docbook XSL stylesheets recipe in OE yet
do_configure_prepend() {
	sed -i s/help// Makefile.am
}

do_configure_append() {
	sed -i 's,func_fatal_error "error: cannot install,echo "bogus message about,' ${HOST_SYS}-libtool
}

RRECOMMENDS_${PN} += "obexd obex-data-server"
RCONFLICTS_${PN} = "bluez-gnome"

FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"
