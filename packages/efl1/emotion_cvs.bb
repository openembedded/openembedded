DESCRIPTION = "The Enlightenment multimedia library"
LICENSE = "MIT BSD"
# we no longer build the libxine backend, since the gstreamer backend seems more promising
DEPENDS = "eet evas ecore edje gstreamer gst-plugins-base"
RRECOMMENDS_${PN} = "emotion-backend-gstreamer"
PV = "0.1.0+cvs${SRCDATE}"
PR = "r0"

inherit efl_library

EXTRA_OECONF = "--disable-xine --enable-gstreamer"

PACKAGES =+ "emotion-backend-gstreamer emotion-test"
FILES_emotion-backend-gstreamer = "${libdir}/emotion/*.so"
FILES_emotion-test = "${bindir}/emotion_test ${datadir}"
