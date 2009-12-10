DESCRIPTION = "Euphony is a instrument loader that gives simple edje-guis a platform with soundsupport to let you play music"
DEPENDS = "ecore evas edje eet fluidsynth"
LICENSE = "BSD 3-clause"
SECTION = "x11/multimedia"

inherit autotools 

SRC_URI = "http://projects.gstaedtner.net/euphony/${PN}-${PV}.tar.gz"
PR = "r1"

FILES_${PN} += "${datadir}"

