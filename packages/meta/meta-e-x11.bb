DESCRIPTION = "Meta-package for Enlightenment/X11"
PACKAGES = "e e-libs e-base"

FEED_URIS += "x11##http://openzaurus.org/official/unstable/3.5.2/feed/x11 \
              e##http://openzaurus.org/official/unstable/3.5.2/feed/e"

ALLOW_EMPTY = 1
RDEPENDS_e = "e-libs e-base"

task-e-libs = "virtual/libiconv imlib2-x11 edb eet evas-x11 ecore-x11 \
               epeg embryo epsylon edje esmart emotion etox ewl"

task-e-base = "entrance e17 e-iconbar e-utils"

RDEPENDS_e-libs = "${task-e-libs}"
DEPENDS += "${task-e-libs}"

RDEPENDS_e-base = "${task-e-base}"
DEPENDS += "${task-e-base}"
LICENSE = MIT
