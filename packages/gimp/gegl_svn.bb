DESCRIPTION = "GEGL (Generic Graphics Library) is a graph based image processing framework."
LICENSE = "LGPL"
DEPENDS = "babl glib-2.0 gtk+ pango cairo expat zlib libpng jpeg virtual/libsdl"

PV = "0.0.12+svn${SRCDATE}"

inherit gnome

SRC_URI = "svn://svn.gnome.org/svn/${PN};module=trunk"

S = "${WORKDIR}/trunk"

do_configure_prepend() {
        sed -i -e s:tools\ docs:tools:g Makefile.am
}

FILES_${PN} += "${libdir}/gegl-1.0"
FILES_${PN}-dbg += "${libdir}/gegl-1.0/.debug"


do_stage() {
        autotools_stage_all
}

