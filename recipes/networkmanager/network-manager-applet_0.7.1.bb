DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPL"
DEPENDS = "policykit-gnome libnotify networkmanager dbus-glib libglade gconf gnome-keyring"
RDEPENDS = "networkmanager"

PR = "r2"

inherit gnome

SRC_URI += "file://nm-applet.conf"

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

SRC_URI[archive.md5sum] = "d90a997e3e2051ce8866fe24f765141f"
SRC_URI[archive.sha256sum] = "b22a90e6252d798b3889843910a016d185f9e87dd23e203003b1072013f670a6"
