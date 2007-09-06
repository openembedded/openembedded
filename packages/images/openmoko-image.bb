#------------------------------------------------------
# OpenMoko Image Recipe
#------------------------------------------------------

IMAGE_LINGUAS = ""

IMAGE_INSTALL = "\
  ${MACHINE_TASK_PROVIDER} \
  task-openmoko-linux \
  task-openmoko-net \
  task-openmoko-ui \
  task-openmoko-base \
  task-openmoko-phone \
  task-openmoko-games \
  task-openmoko-pim \
  "

DEPENDS = "\
  ${MACHINE_TASK_PROVIDER} \
  task-openmoko \
"


inherit image

ROOTFS_POSTPROCESS_COMMAND += 'date "+%m%d%H%M%Y" >${IMAGE_ROOTFS}/etc/timestamp'
