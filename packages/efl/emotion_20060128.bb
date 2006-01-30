DESCRIPTION = "Emotion is a multimedia library based on libxine"
LICENSE = "MIT"
DEPENDS = "eet virtual/evas edje virtual/ecore embryo virtual/libxine"
RDEPENDS += "libemotion-themes libemotion-plugins"
PR = "r2"

#FIXME: Needs patch not to build the examples when building against ecore-fb, because the examples depend on ecore-x11

inherit efl

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/libs/emotion;date=${PV}"
S = "${WORKDIR}/emotion"

PACKAGES += "emotion-plugins"
FILES_emotion-plugins = "${libdir}/xine/plugins/1.1.0/*.so ${libdir}/emotion/*.so"

do_compile_prepend() {
	find ${S} -type f -name "*.[ch]" | xargs sed -i 's:NULL:0:g'
}