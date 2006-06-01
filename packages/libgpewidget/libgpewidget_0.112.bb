LICENSE     = "LGPL"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION     = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ cairo libxrender gtk-doc intltool-native"
MAINTAINER  = "Florian Boor <florian.boor@kernelconcepts.de>"
PR          = "r0"

PACKAGES =+ "libgpewidget-bin"

PARALLEL_MAKE = ""

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
           file://pkgconfig.patch;patch=1;pnum=0"

inherit pkgconfig autotools

FILES_libgpewidget-bin = "${bindir}"

EXTRA_OECONF = "--enable-cairo"

LDFLAGS += " -L${STAGING_LIBDIR}" 

do_stage () {
	autotools_stage_all
}

do_configure () {
	autotools_do_configure
}
