DESCRIPTION = "Frontend applet for NetworkManager" 
LICENSE = "GPLv2"

DEPENDS = "networkmanager dbus-glib libglade gconf gnome-keyring libnotify libgnomeui "

inherit gnome

S = "${WORKDIR}/nm-applet-${PV}"

FILES_${PN} += "${datadir}/nm-applet/ \
                ${datadir}/icons \
		${datadir}/gnome \
		"

