LICENSE = "LGPL"
PR = "r3"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ cairo libxrender gtk-doc"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe pkgconfig autotools

SRC_URI += "file://cairo.patch;patch=1;pnum=1"

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	oe_libinstall -C .libs -so libgpewidget ${STAGING_LIBDIR}
	autotools_stage_includes
}

