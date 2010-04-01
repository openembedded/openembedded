DESCRIPTION = "Gnome system monitor"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "libgtop gtkmm glibmm libnotify libgnomeui gnome-panel gnome-doc-utils libwnck gtk+ gnome-keyring libglade hal dbus-glib " 

inherit gnome

SRC_URI[archive.md5sum] = "064cf1a97d3dd1946bc3e55d8272c2c8"
SRC_URI[archive.sha256sum] = "25b2566af336c44dc279afd7a522e3616b68047f1a1a34c8a5024a52f894429b"

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

