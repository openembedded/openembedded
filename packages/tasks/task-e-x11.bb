DESCRIPTION = "Tasks for Enlightenment/X11"
PACKAGES = "task-e-x11-core task-e-x11"
PROVIDES = "task-e-x11-core task-e-x11"
PR = "r9"

PREFERRED_PROVIDER_virtual/imlib2 = "imlib-x11"

ALLOW_EMPTY = 1

#
# X
#
RDEPENDS_task-e-x11-core = "rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo \
                            ttf-bitstream-vera chkhinge gpe-bootsplash-theme-e"

#
# E-core
#
RDEPENDS_task-e-x11-core += "entrance e-wm"


RDEPENDS_task-e-x11  = "task-e-x11-core"
# entice eclair examine evidence e-modules e-utils elitaire"
DEPENDS_task-e-x11 = "task-e-x11-core"
# entice eclair examine evidence e-modules e-utils elitaire"
