DESCRIPTION = "Meta-package for Enlightenment/X11"
LICENSE = "MIT"
PACKAGES = "task-enlightenment-x11"

FEED_URIS += "x11##http://openzaurus.org/official/unstable/3.5.2/feed/x11 \
              e##http://openzaurus.org/official/unstable/3.5.2/feed/e"

ALLOW_EMPTY = 1

#
# X
#
DEPENDS  += "diet-x11 rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo"
RDEPENDS += "         rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo"

#
# E
#
DEPENDS  += "entrance e-wm entice"
RDEPENDS += "entrance e-wm entice"

