include imlib2.inc

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/libs/imlib2;date=${PV}"
S = "${WORKDIR}/imlib2"

inherit native
PROVIDES = "imlib2-native"
DEPENDS = "freetype-native libpng-native jpeg-native"

EXTRA_OECONF = "--disable-mmx \
                --without-x"
