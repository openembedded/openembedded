LICENSE = "LGPL"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "gtk+ cairo libxrender gtk-doc"
PR = "r1"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe pkgconfig autotools

PACKAGES =+ "libgpewidget-bin"
FILES_libgpewidget-bin = "${bindir}"

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	autotools_stage_all
}

