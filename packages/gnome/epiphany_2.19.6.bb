DESCRIPTION = "GNOME default webbrowser"
DEPENDS = "gnome-desktop gnome-vfs libgnomeui webkit-gtk iso-codes libstartup-notification"
RDEPENDS = "gnome-vfs-plugin-http"

PR = "r1"

inherit gnome

EXTRA_OECONF = "--with-engine=webkit"


FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"


