LICENSE = "GPL"
SECTION = "x11/utils"
PR = "r2"

inherit gnome gettext

DEPENDS = "gtk+ libgnomeui libbonoboui gnome-vfs gconf gettext libglade \
	libgnomeprint libgnomeprintui gnome-common"

EXTRA_OECONF = "--disable-schemas-install"

SRC_URI += "file://aclocal-lossage.patch;patch=1 \
	file://desktop.patch;patch=1"
