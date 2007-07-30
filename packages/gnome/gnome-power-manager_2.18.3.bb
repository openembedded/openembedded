LICENSE = "GPLv2"
DEPENDS = "libnotify libgnomeui gnome-panel gnome-doc-utils libwnck gtk+ gnome-keyring libglade hal dbus-glib " 

PR = "r1"

inherit gnome

EXTRA_OECONF = " --disable-scrollkeeper \
                 --disable-keyring \
		 "

do_configure_append() {
        rm config.log
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

