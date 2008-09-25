DESCRIPTION = "Liboil is a library of simple functions that are optimized for various CPUs."
HOMEPAGE = "http://liboil.freedesktop.org/"
LICENSE = "various"
PR = "r1"

DEPENDS = "glib-2.0"

SRC_URI = "http://liboil.freedesktop.org/download/${P}.tar.gz \
	   file://autotools.patch;patch=1 \
          "

inherit autotools pkgconfig

EXTRA_OECONF = "\
        ${@['','--enable-softfloat'][bb.data.getVar('TARGET_FPU',d,1) == 'soft']} \
	       "

do_stage() {
	autotools_stage_all
}
