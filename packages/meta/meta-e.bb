DESCRIPTION = "Meta-package for the Enlightenment Palmtop Environment (Codename: EpiCenter)"
PACKAGES = "e e-libs e-base"

FEED_URIS += "e##http://openzaurus.org/official/unstable/3.5.2/feed/e"

ALLOW_EMPTY = 1

task-e-libs = "evas edb ecore eet embryo edje etox ewl"
task-e-base = ""

RDEPENDS_e-libs = "${task-e-libs}"
DEPENDS += "${task-e-libs}"

RDEPENDS_e-base = "${task-e-base}"
DEPENDS += "${task-e-base}"
LICENSE = MIT
