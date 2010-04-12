DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPL"
DEPENDS = "gnome-bluetooth policykit-gnome libnotify networkmanager dbus-glib libglade gconf gnome-keyring"
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

FILES_${PN} += "${libdir}/gnome-bluetooth/plugins/*.so"
FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"


SRC_URI[archive.md5sum] = "27071402152a7f8f62c4825f25ca9a3a"
SRC_URI[archive.sha256sum] = "6379e0acd3eadeb71e3ba2e3cf05d351caf6b794dff5777a5e86a591df603bd4"
