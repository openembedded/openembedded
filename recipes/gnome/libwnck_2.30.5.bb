DESCRIPTION = "Window navigation construction toolkit"
LICENSE = "LGPL"
SECTION = "x11/libs"
DEPENDS = "gtk+ gtk+-native"
PR = "r1"
inherit gnome

SRC_URI += "file://introspection.patch"

SRC_URI[archive.md5sum] = "4162d5b96151e6d24ec02ae3a822203c"
SRC_URI[archive.sha256sum] = "56b6681e89cd45491bb640165d62276d81369a08974042b26645dc1e0e954cc1"

EXTRA_OECONF += "--enable-introspection=no"
