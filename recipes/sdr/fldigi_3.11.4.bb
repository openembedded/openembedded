DESCRIPTION = "Digital modem program for Linux"
LICENSE = "GPLv2"

DEPENDS = "libsndfile1 portaudio-v19 hamlib jpeg fltk libsamplerate0 pulseaudio"

inherit autotools_stage

SRC_URI = "http://www.w1hkj.com/fldigi-distro/fldigi-${PV}.tar.gz"

EXTRA_OECONF = " --enable-static --without-jpeg"



SRC_URI[md5sum] = "85457a57ac97210ee23299ccf25e5c60"
SRC_URI[sha256sum] = "1614d6720994a5b794d50b05d95dfd1f1cc556fcd500352f0203daeae88be0dd"
