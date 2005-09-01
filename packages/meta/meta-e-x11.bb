DESCRIPTION = "Meta-package for Enlightenment/X11"
LICENSE = "MIT"
PACKAGES = "task-e-x11-core task-e-x11"
PROVIDES = "task-e-x11-core task-e-x11"
PR = "r6"

FEED_URIS += "x11##http://openzaurus.org/official/unstable/3.5.2/feed/x11 \
              e##http://openzaurus.org/official/unstable/3.5.2/feed/e"

ALLOW_EMPTY = 1

#
# X
#
DEPENDS =                  "diet-x11 rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo fontconfig \
                                         ttf-bitstream-vera chkhinge"
RDEPENDS_task-e-x11-core = "         rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo            \
                                         ttf-bitstream-vera chkhinge"

#
# E-core
#
DEPENDS +=                  "entrance e-wm"
RDEPENDS_task-e-x11-core += "entrance e-wm"

#
# E
#
DEPENDS +=             "                entice eclair examine evidence e-modules e-utils elitaire"
RDEPENDS_task-e-x11 += "task-e-x11-core entice eclair examine evidence e-modules e-utils elitaire"

