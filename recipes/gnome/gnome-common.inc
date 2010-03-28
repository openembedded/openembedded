LICENSE = "GPL"
SECTION = "x11/gnome"
DESCRIPTION = "Common macros for building GNOME applications"

inherit gnome

# The omf.make file failed if scrollkeeper doesn't happen to be
# installed

SRC_URI += "file://omf.patch;patch=1"

EXTRA_AUTORECONF = ""
DEPENDS = ""

FILES_${PN} += "${datadir}/aclocal"
FILES_${PN}-dev = ""

