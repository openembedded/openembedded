DESCRIPTION = "Emotion is a multimedia library based on libxine"
LICENSE = "MIT"
DEPENDS = "eet virtual/evas edje virtual/ecore embryo gstreamer gst-plugins-base"
# virtual/libxine
#RPROVIDES += "emotion-themes emotion-plugins"
RDEPENDS += "emotion-themes emotion-plugins"

PR = "r1"

#FIXME: Needs patch not to build the examples when building against ecore-fb, because the examples depend on ecore-x11

inherit efl

SRC_URI = "${E_CVS};module=e17/libs/emotion;date=${PV}"
S = "${WORKDIR}/emotion"

PACKAGES += "emotion-plugins"
FILES_emotion-plugins = "${libdir}/xine/plugins/1.1.0/*.so ${libdir}/emotion/*.so"
