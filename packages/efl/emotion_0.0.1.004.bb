DESCRIPTION = "Emotion is a multimedia library based on libxine"
LICENSE = "MIT"
DEPENDS = "eet virtual/evas edje virtual/ecore embryo virtual/libxine"
RDEPENDS += "libemotion-themes libemotion-plugins"
PR = "r2"

#FIXME: Needs patch not to build the examples when building against ecore-fb, because the examples depend on ecore-x11

inherit efl

PACKAGES += "emotion-plugins"
FILES_emotion-plugins = "${libdir}/xine/plugins/1.1.0/*.so ${libdir}/emotion/*.so"
