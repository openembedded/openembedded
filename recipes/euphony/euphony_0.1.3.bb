DESCRIPTION = "Euphony is a instrument loader that gives simple edje-guis a platform with soundsupport to let you play music"
DEPENDS = "ecore evas edje eet fluidsynth"
LICENSE = "BSD 3-clause"
SECTION = "x11/multimedia"

inherit autotools 

SRC_URI = "http://projects.gstaedtner.net/euphony/${PN}-${PV}.tar.gz"
PR = "r1"

FILES_${PN} += "${datadir}"


SRC_URI[md5sum] = "47d5663f0c66177e3529b9062f9b071f"
SRC_URI[sha256sum] = "30f035bc39967f72f3ac8740d78f4d5e611577ea2b90f47f4cd72d6729fd4ce5"
