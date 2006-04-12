DESCRIPTION = "Meta-package for the Enlightenment Palmtop Environment (Codename: EpiCenter)"
PACKAGES = "e e-libs e-base"
PACKAGE_ARCH = "all"
PR = "r1"

FEED_URIS_append_openzaurus = " x11##${FEED_BASE_URI}/feed/x11 "

ALLOW_EMPTY = 1

task-e-libs = "evas edb ecore eet embryo edje etox ewl"
task-e-base = ""

RDEPENDS_e-libs = "${task-e-libs}"
DEPENDS += "${task-e-libs}"

RDEPENDS_e-base = "${task-e-base}"
DEPENDS += "${task-e-base}"
LICENSE = MIT
