DESCRIPTION = "A GPE application that allows you to take screenshots."
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "gpe"
PR = "r2"

RREPLACES = "gpe-screenshot"

DEPENDS = "glib-2.0 gtk+ libgpewidget libglade libsoup"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools

SRC_URI += " file://allow-glade-2.4.0.patch;patch=1"

SRC_URI[md5sum] = "7ba3d2592585c8bcf9d3bf1aafeefef3"
SRC_URI[sha256sum] = "609e24aa1413b1053ee3fd42c36c6ccf05d8067867021511c7d50d4829875b44"
