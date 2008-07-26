DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
LICENSE = "LGPL"
SECTION = "gpe/libs"
DEPENDS = "gtk+ cairo libxinerama libxrender gtk-doc"
PR = "r2"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe pkgconfig autotools

SRC_URI += "file://pkgconfig.patch;patch=1;pnum=0"

EXTRA_OECONF = "--enable-cairo"

LDFLAGS += " -L${STAGING_LIBDIR}"

do_stage () {
	autotools_stage_all
}

PACKAGES =+ "libgpewidget-bin"
FILES_libgpewidget-bin = "${bindir}/*"
RRECOMMENDS = "gpe-icons"
