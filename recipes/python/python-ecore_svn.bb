require python-efl.inc
DEPENDS += "python-evas ecore"
RDEPENDS += "python-evas"
PR="r1"

SRC_URI += "file://ecore-x.patch;patch=0"

do_stage() {
    distutils_stage_all
}
