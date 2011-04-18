DESCRIPTION = "Gnome dconf"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = ""

inherit gnome

SRC_URI[archive.md5sum] = "c905497d0255fe2ba58564f9655908ab"
SRC_URI[archive.sha256sum] = "0083d70e1b5e540d8d4b3f04fa5d17dff4c574136682fe3bdd9b5ecc196ec4f6"

FILES_${PN} += "${datadir}/dbus-1/ \
                ${datadir}/vala \
                ${libdir}//gio/modules/*.so \
               "

