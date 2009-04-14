require python-efl.inc
DEPENDS += "python-evas ecore"
RDEPENDS += "python-evas"

SRC_URI += "file://ecore_window_free.patch;patch=1"

do_stage() {
    distutils_stage_all
}
