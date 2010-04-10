DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPL"
DEPENDS = "policykit-gnome libnotify networkmanager dbus-glib libglade gconf gnome-keyring"
RDEPENDS = "networkmanager"

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

SRC_URI[archive.md5sum] = "3183f5ae3553da0ce9c381dadbcc19e0"
SRC_URI[archive.sha256sum] = "34316707a323b883f347b2566fd2dc7a3134b2bf432fb3a8b31d88829b0947e3"
