DESCRIPTION = "Meta-package for Enlightenment X11 Without FrameBuffer"
MAINTAINER = "That Crazy fool emte <emte@labotomy.net>"
PACKAGES = "e e-libs e-base"

FEED_URIS += "x11##http://openzaurus.org/official/unstable/3.5.2/feed/x11 \
              e##http://openzaurus.org/official/unstable/3.5.2/feed/e"

ALLOW_EMPTY = 1

# task-e-libs = "virtual/libiconv imlib2 edb eet evas ecore epeg epsilon embryo edje esmart emotion etox ewl"
# epsilon is currently broke for cross compiling without a patch, raster is looking at it

task-e-libs = "virtual/libiconv imlib2 edb eet evas ecore epeg embryo edje esmart emotion etox ewl"

task-e-base = ""

RDEPENDS_e-libs = "${task-e-libs}"
DEPENDS += "${task-e-libs}"

RDEPENDS_e-base = "${task-e-base}"
DEPENDS += "${task-e-base}"
LICENSE = MIT
