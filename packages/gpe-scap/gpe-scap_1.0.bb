DESCRIPTION = "GPE screenshot application"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "gpe"
PR = "r0"

RREPLACES = "gpe-screenshot"

DEPENDS = "glib-2.0 gtk+ libglade"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools

