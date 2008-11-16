DESCRIPTION = "GEGL (Generic Graphics Library) is a graph based image processing framework."
LICENSE = "LGPL"
DEPENDS = "babl librsvg glib-2.0 gtk+ pango cairo expat zlib libpng jpeg virtual/libsdl"

SRCREV = "2543"
PV = "0.0.19+svnr${SRCREV}"
PE = "1"

inherit gnome

SRC_URI = "svn://svn.gnome.org/svn/${PN};module=trunk"

S = "${WORKDIR}/trunk"

EXTRA_OECONF = "--disable-docs "

FILES_${PN} += "${libdir}/gegl-0.0"
FILES_${PN}-dbg += "${libdir}/gegl-0.0/.debug"


do_stage() {
        autotools_stage_all
}

