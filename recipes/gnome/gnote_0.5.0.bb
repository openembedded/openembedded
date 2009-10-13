DESCRIPTION = "Note taking application"
LICENSE = "GPL"

DEPENDS = "libpcre libgnomeui gconf gtkmm boost"

inherit gnome

FILES_${PN}-dbg += "${libdir}/gnote/*/*/.debug"
