DESCRIPTION = "Gnome games extra data"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gnome-games"

inherit gnome

SRC_URI[archive.md5sum] = "dab5e24779b77bf9f9b1b422460a9a97"
SRC_URI[archive.sha256sum] = "c997ae69a8cadf31c177991ab2b196cc006eac349273d68ebfc77d09bd270f73"

FILES_${PN} += " ${datadir}/gnome-games*"
FILES_${PN}-doc += "${datadir}/omf"

