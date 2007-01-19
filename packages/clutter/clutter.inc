DESCRIPTION = "Clutter graphics library"
HOMEPAGE = "http://www.clutter-project.org/"
LICENSE = "LGPL"

DEPENDS = "virtual/libx11 mesa gstreamer gtk-doc cairo pango gtk+"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc "

#check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
require clutter-fpu.inc

EXTRA_OECONF += "${@get_clutter_fpu_setting(bb, d)}"

#Fix up some weirdness in the docs
do_configure_prepend() {
	touch ${S}/gtk-doc.make
        sed -i s:doc/reference/Makefile::g ${S}/configure.ac
        sed -i s:doc::g ${S}/Makefile.am
}

do_stage () {
        autotools_stage_all
}

