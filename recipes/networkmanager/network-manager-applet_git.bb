DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPL"
DEPENDS = "libnotify networkmanager dbus-glib libglade gconf gnome-keyring"
RDEPENDS_${PN} = "networkmanager"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRCREV = "0.8.3.999"
PV = "0.8.3.999"
#PR_append = ".gitr${SRCREV}"

inherit gnome

SRC_URI = "git://git.gnome.org/network-manager-applet;protocol=git;branch=NMA_0_8 \
           file://nm-applet.conf"

S = "${WORKDIR}/git"

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

