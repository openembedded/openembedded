DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPL"
DEPENDS = "gnome-bluetooth policykit-gnome libnotify networkmanager dbus-glib libglade gconf gnome-keyring"
RDEPENDS_${PN} = "networkmanager"

inherit gnome

SRC_URI += "file://nm-applet.conf"

SRC_URI[archive.md5sum] = "b709808c1a5cfe8236061b5da4907313"
SRC_URI[archive.sha256sum] = "4a84b9762c6fa13004f66a5e208236d2c4b0a15fcbf47da19b6b44b441aec366"

do_configure_append() {
        rm config.log
        # Sigh... --enable-compile-warnings=no doesn't actually turn off -Werror
        for i in $(find ${S} -name "Makefile") ; do
            sed -i -e s:-Werror::g $i
        done
}

# Hack around dbus a_console problems
do_install_append() {
	install -m 0644 ${WORKDIR}/nm-applet.conf ${D}${sysconfdir}/dbus-1/system.d/
}

FILES_${PN} += "${datadir}/nm-applet/ \
        ${datadir}/gnome-vpn-properties/ \
        ${datadir}/gnome/autostart/ \
        "

FILES_${PN} += "${libdir}/gnome-bluetooth/plugins/*.so"
FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"

