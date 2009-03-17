DESCRIPTION = "Editor for the GPE Palmtop Environment"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"

GPE_TARBALL_SUFFIX ?= "bz2"

inherit gpe autotools
