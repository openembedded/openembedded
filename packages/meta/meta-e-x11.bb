DESCRIPTION = "Meta-package for Enlightenment/X11"
LICENSE = "MIT"
PACKAGES = "task-enlightenment-x11"
PR = "r2"

FEED_URIS += "x11##http://openzaurus.org/official/unstable/3.5.2/feed/x11 \
              e##http://openzaurus.org/official/unstable/3.5.2/feed/e"

ALLOW_EMPTY = 1

#
# X
#
DEPENDS  += "diet-x11 rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo fontconfig \
             ttf-bitstream-vera bash"
RDEPENDS += "         rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo            \
             ttf-bitstream-vera"

#
# E
#
DEPENDS  += "entrance e-wm entice eclair examine "
RDEPENDS += "entrance e-wm entice eclair examine "

