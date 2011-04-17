DESCRIPTION = "Gnome desktop schemas"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = ""

inherit gnome

SRC_URI[archive.md5sum] = "227f020980c746fbf4da21991b107184"
SRC_URI[archive.sha256sum] = "1b8d7f6141379f3ab58ca917baa3eb947e78d6425664b21dc199a35f99991af6"

FILES_${PN} += " \
                ${datadir}/GConf/ \
                ${datadir}/glib-2.0/schemas/ \
               "

