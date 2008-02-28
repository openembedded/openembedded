DESCRIPTION = "Task for a FIC Neo SmartPhone environment"
LICENSE = "MIT"
SECTION = "devel/python"
PR = "r2"

ALLOW_EMPTY = "1"

RDEPENDS = "\
  matchbox-wm \
  ${XSERVER} \
  xserver-kdrive-common \
  xserver-nodm-init \
  xauth \
  xhost \
  xset \
  xrandr \
  \
  gsm0710muxd \
  pyneod \
  pyneog \
"

