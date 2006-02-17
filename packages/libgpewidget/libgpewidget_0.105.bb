LICENSE = "LGPL"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ cairo libxrender gtk-doc"
PR = "r1"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe pkgconfig autotools

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	autotools_stage_all
}

