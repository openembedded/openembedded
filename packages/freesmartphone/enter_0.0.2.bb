DESCRIPTION = "An easy-to-use virtual keyboard for small touchscreen displays"
SECTION = "openmoko/inputmethods"
DEPENDS = "ecore evas edje"
PR = "r0"

inherit autotools

SRC_URI = "http://gstaedtner.net/projects/enter/enter.tar.gz"

FILES_${PN} += "${datadir}"
