DESCRIPTION = "Validation image with e17 desktop"

inherit image

export IMAGE_BASENAME = "validation-e17-image"

IMAGE_LINGUAS = "de-de fr-fr en-gb en-us pt-br es-es kn-in ml-in ta-in"
ROOTFS_POSTPROCESS_COMMAND += 'install_linguas; '
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_LOGIN_MANAGER = "shadow"
IMAGE_SPLASH = "psplash-angstrom"

ANGSTROM_EXTRA_INSTALL ?= ""

IMAGE_INSTALL += " \
  task-omap-drivers \
  task-base-extended \
  task-beagleboard-validation-base \
  task-beagleboard-validation-gui \
  ${ANGSTROM_EXTRA_INSTALL} \
  ${IMAGE_SPLASH} \
"

