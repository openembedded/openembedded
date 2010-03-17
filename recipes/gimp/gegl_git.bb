DESCRIPTION = "GEGL (Generic Graphics Library) is a graph based image processing framework."
LICENSE = "LGPL"
DEPENDS = "babl librsvg glib-2.0 gtk+ pango cairo expat zlib libpng jpeg virtual/libsdl"

SRCREV = "fc674b5420cbc48f4dc6224381b8799db4e7afc4"
PV = "0.1.3"
PE = "1"
PR = "r1+gitr${SRCREV}"

inherit gnome

SRC_URI = "git://git.gnome.org/gegl;protocol=git \
"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-docs "

FILES_${PN} += "${libdir}/gegl-*"
FILES_${PN}-dbg += "${libdir}/gegl-*/.debug"

