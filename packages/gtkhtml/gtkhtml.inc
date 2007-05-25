DESCRIPTION = "HTML rendering/editing library"
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "GPL"

inherit gnome

S = "${WORKDIR}/gtkhtml-${PV}"

EXTRA_OECONF = "--disable-gtk-doc"
