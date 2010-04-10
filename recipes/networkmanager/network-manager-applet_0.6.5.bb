DESCRIPTION = "Frontend applet for NetworkManager" 
LICENSE = "GPLv2"

DEPENDS = "networkmanager dbus-glib libglade gconf gnome-keyring libnotify libgnomeui "

inherit gnome

S = "${WORKDIR}/nm-applet-${PV}"

FILES_${PN} += "${datadir}/nm-applet/ \
                ${datadir}/icons \
		${datadir}/gnome \
		"


SRC_URI[archive.md5sum] = "1c94a41e2399d261985a75f0cd3b895b"
SRC_URI[archive.sha256sum] = "9cca3e34e23f00c82bc5e7237aa81639874e90d43a689e26fbfd938279ca31c9"
