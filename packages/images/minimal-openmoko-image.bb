#------------------------------------------------------
# Minimal OpenMoko Image Recipe
# This should only have the base system + dialer
# #------------------------------------------------------

IMAGE_LINGUAS = ""
ANGSTROM_EXTRA_INSTALL ?= ""

IMAGE_INSTALL = "\
  task-base \
  ${ANGSTROM_EXTRA_INSTALL} \
  task-openmoko-linux \
  task-openmoko-net \
  task-openmoko-ui \
  task-openmoko-base \
  task-openmoko-phone \
  "

inherit image

ROOTFS_POSTPROCESS_COMMAND += 'date "+%m%d%H%M%Y" >${IMAGE_ROOTFS}/etc/timestamp'
