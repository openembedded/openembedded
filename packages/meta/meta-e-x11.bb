DESCRIPTION = "Meta-package for Enlightenment/X11"
PACKAGES = "task-e-x11"
PROVIDES = "task-e-x11"
PACKAGE_ARCH = "all"
PR = "r7"

FEED_URIS_append_openzaurus = " x11##${FEED_BASE_URI}/feed/x11 "

ALLOW_EMPTY = 1

DEPENDS              = "task-e-x11-core entice eclair examine evidence e-modules e-utils elitaire"
RDEPENDS_task-e-x11  = "task-e-x11-core entice eclair examine evidence e-modules e-utils elitaire"

