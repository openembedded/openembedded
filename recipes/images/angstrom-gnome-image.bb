DESCRIPTION = "Image based on the GNOME desktop"

inherit image

export IMAGE_BASENAME = "GNOME-image"

IMAGE_LINGUAS = "de-de fr-fr en-gb en-us pt-br es-es kn-in ml-in ta-in"
ROOTFS_POSTPROCESS_COMMAND += 'install_linguas;'

IMAGE_LOGIN_MANAGER = "shadow"

ANGSTROM_EXTRA_INSTALL ?= ""

SPLASH = "psplash-angstrom"

IMAGE_INSTALL += " \
  task-base-extended \
  ${ANGSTROM_EXTRA_INSTALL} \
  ${SPLASH} \
  angstrom-task-gnome \
"

