#------------------------------------------------------
# Openmoko Minimal Image Recipe
# other openmoko images should include this.
# -----------------------------------------------------

IMAGE_LINGUAS = ""

IMAGE_INSTALL = "\
  ${MACHINE_TASK_PROVIDER} \
  task-openmoko-linux \
  "

DEPENDS = "\
  ${MACHINE_TASK_PROVIDER} \
  task-openmoko-linux \
  "


inherit image

ROOTFS_POSTPROCESS_COMMAND += 'date "+%m%d%H%M%Y" >${IMAGE_ROOTFS}/etc/timestamp'
