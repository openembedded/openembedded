LICENSE = "LGPL"
PR = "r2"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ cairo libxrender gtk-doc intltool-native"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
		file://cairo.patch;patch=1;pnum=1"

inherit pkgconfig autotools

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	oe_libinstall -C .libs -so libgpewidget ${STAGING_LIBDIR}
	autotools_stage_includes
}

