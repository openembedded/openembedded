DESCRIPTION = "Meta-package for Enlightenment/X11 Core"
PACKAGES = "task-e-x11-core"
PROVIDES = "task-e-x11-core"
PR = "r6"

FEED_URIS += "x11##http://openzaurus.org/official/unstable/3.5.2/feed/x11 \
              e##http://openzaurus.org/official/unstable/3.5.2/feed/e"

PREFERRED_PROVIDER_virtual/imlib2 = "imlib-x11"

ALLOW_EMPTY = 1

#
# X
#
RDEPENDS_task-e-x11-core = " rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo \
                             ttf-bitstream-vera chkhinge"

#
# E-core
#
RDEPENDS_task-e-x11-core += "entrance e-wm"
