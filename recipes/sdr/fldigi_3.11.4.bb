DESCRIPTION = "Digital modem program for Linux"
LICENSE = "GPLv2"

DEPENDS = "libsndfile1 portaudio-v19 hamlib jpeg fltk libsamplerate0 pulseaudio"

inherit autotools_stage

SRC_URI = "http://www.w1hkj.com/fldigi-distro/fldigi-${PV}.tar.gz"

EXTRA_OECONF = " --enable-static --without-jpeg"


