LICENSE = "GPL"
PR = "r1"

inherit gpe pkgconfig

SRC_URI += "file://gpemixer-no-host-includes.patch;patch=1"

DESCRIPTION = "GPE audio mixer"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"

