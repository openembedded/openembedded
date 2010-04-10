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

SRC_URI[md5sum] = "88d53855c41fa7713263e913871a5fcc"
SRC_URI[sha256sum] = "ebbbc25a27587c21ed640b5d87b7c7783f4820c59c22f7b07e29e2306f1bbd65"
