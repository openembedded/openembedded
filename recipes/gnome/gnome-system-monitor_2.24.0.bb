LICENSE = "GPLv2"
DEPENDS = "libgtop gtkmm glibmm libnotify libgnomeui gnome-panel gnome-doc-utils libwnck gtk+ gnome-keyring libglade hal dbus-glib " 

inherit gnome

do_configure_prepend() {
        sed -i -e s:help::g ${S}/Makefile.am
}


PACKAGES =+ "${PN}-applets"

FILES_${PN}-applets = "${bindir}/*applet* \
                       ${libdir}/bonobo/servers \
		       ${datadir}/gnome-2.0/ui"

FILES_${PN} += "${datadir}/icons \
                ${datadir}/dbus-1 \
		${datadir}/gnome/autostart \
		"

FILE_{PN}-doc += "${datadir}/omf \
                  ${datadir}/gnome/help "


SRC_URI[archive.md5sum] = "edd7f02e30683054b94a89aa62c74d1e"
SRC_URI[archive.sha256sum] = "cf2f96f3c91749fdcec39d3eb89273f6d3a47cc7bc0c5faa0915808409c9d563"
