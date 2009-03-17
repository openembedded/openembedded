DESCRIPTION = "Horizon is a sketchbook application for tablet devices."
LICENSE = "GPLv2"
SECTION = "x11/graphics"
DEPENDS = "glib-2.0 libpng jpeg virtual/libsdl"
PR = "r1"

SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=horizon \
	file://makefile.patch;patch=1"

inherit pkgconfig binconfig

S = "${WORKDIR}/horizon"
PV = "0.37+cvs${SRCDATE}"

PARALLEL_MAKE = ""

CFLAGS += " -I${STAGING_INCDIR} -I${STAGING_INCDIR}/SDL -I. -Isrc -L${STAGING_LIBDIR} `PKG_CONFIG_PATH=${STAGING_DATADIR}/pkgconfig pkg-config --cflags glib-2.0 gobject-2.0 libpng`"

do_compile() {
	#yes, this is a hack to work around a faulty makefile
	oe_runmake horizon
}

do_install() {
	install -d ${D}${bindir}
	install -m 755 horizon ${D}${bindir}
}

