LICENSE = "LGPL"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "gtk+ cairo libxrender gtk-doc intltool-native"

PACKAGES =+ "libgpewidget-bin"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

inherit pkgconfig autotools

FILES_libgpewidget-bin = "${bindir}"

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	autotools_stage_all
}

