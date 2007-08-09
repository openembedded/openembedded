DESCRIPTION = "GPE screenshot application"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "gpe"
PR = "r1"

RREPLACES = "gpe-screenshot"

DEPENDS = "glib-2.0 gtk+ libgpewidget libglade libsoup"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools

SRC_URI += " file://deviceinfo.patch;patch=1;pnum=0"
