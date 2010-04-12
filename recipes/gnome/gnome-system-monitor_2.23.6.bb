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


SRC_URI[archive.md5sum] = "bc7e7e252465948b122e267713bba4a0"
SRC_URI[archive.sha256sum] = "4fbd2eccb335fa92487b3307bd83c4f468342f1787856377abbb6ad862271451"
