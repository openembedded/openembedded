DESCRIPTION = "Meta-package for Enlightenment/X11 Core"
PACKAGES = "task-e-x11-core"
PROVIDES = "task-e-x11-core"
PACKAGE_ARCH = "all"
PR = "r7"

FEED_URIS_append_openzaurus = " x11##${FEED_BASE_URI}/feed/x11 "

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

