DESCRIPTION = "Image used for Linuxtag 2010 demo"

inherit image

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-video-sisusb \
           xf86-input-keyboard \
"

export IMAGE_BASENAME = "Linuxtag2010-image"

IMAGE_LINGUAS = "de-de fr-fr en-gb en-us pt-br es-es kn-in ml-in ta-in"
ROOTFS_POSTPROCESS_COMMAND += 'install_linguas;'
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_LOGIN_MANAGER = "shadow"
IMAGE_SPLASH = "psplash-angstrom"


ANGSTROM_EXTRA_INSTALL ?= ""

IMAGE_INSTALL += " \
  task-base-extended \
  ${ANGSTROM_EXTRA_INSTALL} \
  ${IMAGE_SPLASH} \
  angstrom-task-gnome \
  bash \
  gstreamer-ti \
  libgles-omap3-x11wsegl \
  bc-cube-x11 \
  mplayer \
  omapfbplay \
  cpufrequtils \
  htop \
  powertop \
  ntpdate \
  libgles-omap3-x11demos \
  abiword \
  gnumeric \
  epiphany \
  memtester \
  kernel-modules \
"

