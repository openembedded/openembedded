LICENSE     = "LGPL"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ cairo libxinerama libxcomposite libxrender gtk-doc"
PR          = "r0"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe pkgconfig autotools

SRC_URI += "file://pkgconfig.patch;patch=1;pnum=0"

PACKAGES =+ "libgpewidget-bin"
FILES_libgpewidget-bin = "${bindir}/*"

EXTRA_OECONF = "--enable-cairo"

LDFLAGS += " -L${STAGING_LIBDIR}"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "b85a839264a35d0faf9a1a38c486e189"
SRC_URI[sha256sum] = "f96d30c09b0395ea4e146730fd52d9ea303b619bb139051d9f12d3f868a9e18c"
