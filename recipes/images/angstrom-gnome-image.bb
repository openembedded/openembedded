DESCRIPTION = "Image based on the GNOME desktop"

inherit image

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-video-sisusb \
           xf86-input-keyboard \
"

export IMAGE_BASENAME = "GNOME-image"

IMAGE_LINGUAS = "de-de fr-fr en-gb en-us pt-br es-es kn-in ml-in ta-in"
ROOTFS_POSTPROCESS_COMMAND += 'install_linguas;'
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_LOGIN_MANAGER = "shadow"
IMAGE_SPLASH = "exquisite exquisite-themes exquisite-theme-angstrom"

ANGSTROM_EXTRA_INSTALL ?= ""

IMAGE_INSTALL += " \
  task-base-extended \
  ${ANGSTROM_EXTRA_INSTALL} \
  ${IMAGE_SPLASH} \
  angstrom-task-gnome \
  bash \
"

