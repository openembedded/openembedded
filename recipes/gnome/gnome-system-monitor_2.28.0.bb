DESCRIPTION = "Gnome system monitor"
LICENSE = "GPL"
SECTION = "x11/gnome"
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

FILES_${PN}-doc += "${datadir}/omf \
                    ${datadir}/gnome/help "

