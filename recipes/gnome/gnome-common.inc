LICENSE = "GPLv3"
SECTION = "x11/gnome"
DESCRIPTION = "Common macros for building GNOME applications"

inherit gnomebase

# The omf.make file failed if scrollkeeper doesn't happen to be
# installed

SRC_URI += "file://omf.patch"

EXTRA_AUTORECONF = ""
DEPENDS = ""

FILES_${PN} += "${datadir}/aclocal"
FILES_${PN}-dev = ""

BBCLASSEXTEND = "native"
