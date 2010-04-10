DESCRIPTION = "Note taking application"
LICENSE = "GPL"

DEPENDS = "libpcre libgnomeui gconf gtkmm boost"

inherit gnome

FILES_${PN}-dbg += "${libdir}/gnote/*/*/.debug"

SRC_URI[archive.md5sum] = "ca9e67a92945af7230eae72b2e8430ec"
SRC_URI[archive.sha256sum] = "19a1f79c42b37ee3c90ba6298442b52438f1c67d311ebd33db72210cee2d99d2"
