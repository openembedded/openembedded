DESCRIPTION = "Meta-package for Enlightenment/X11"
PACKAGES = "task-e-x11"
PROVIDES = "task-e-x11"
PR = "r6"

FEED_URIS += "x11##http://openzaurus.org/official/unstable/3.5.2/feed/x11 \
              e##http://openzaurus.org/official/unstable/3.5.2/feed/e"

ALLOW_EMPTY = 1

RDEPENDS_task-e-x11  = "task-e-x11-core entice eclair examine evidence e-modules"
# e-utils elitaire

