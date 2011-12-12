DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPL"
DEPENDS = "gnome-bluetooth policykit-gnome libnotify networkmanager dbus-glib libglade gconf gnome-keyring"
RDEPENDS_${PN} = "networkmanager"

inherit gnome

SRC_URI += "file://nm-applet.conf"

SRC_URI[archive.md5sum] = "6c7752183c145ac10f26f8bc6b6ab7af"
SRC_URI[archive.sha256sum] = "753fc9790379ce86efc9fa06a838fbe9f1310e734a63d9b823477ad13690f831"

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

