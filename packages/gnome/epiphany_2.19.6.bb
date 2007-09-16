DESCRIPTION = "GNOME default webbrowser"
DEPENDS = "gnome-desktop gnome-vfs libgnomeui webkit-gtk"

inherit gnome

EXTRA_OECONF = "--with-engine=webkit"


FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"


