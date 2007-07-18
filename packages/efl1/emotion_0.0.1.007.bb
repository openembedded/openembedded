DESCRIPTION = "Emotion is a multimedia library with backends: gstreamer and libxine"
LICENSE = "MIT"
# we no longer build the libxine backend, since the gstreamer backend seems more promising
DEPENDS = "eet evas ecore edje gstreamer gst-plugins-base"
RRECOMMENDS_${PN} = "emotion-backend-gstreamer"
PR = "r0"

inherit efl1

EXTRA_OECONF = "--disable-xine --enable-gstreamer"

PACKAGES =+ "emotion-backend-gstreamer emotion-test"
FILES_emotion-backend-gstreamer = "${libdir}/emotion/*.so"
FILES_emotion-test = "${bindir}/emotion_test ${datadir}"
