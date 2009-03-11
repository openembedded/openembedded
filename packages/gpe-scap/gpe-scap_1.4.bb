DESCRIPTION = "A GPE application that allows you to take screenshots."
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "gpe"
PR = "r0"

RREPLACES = "gpe-screenshot"

DEPENDS = "glib-2.0 gtk+ libgpewidget libglade libsoup"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools
