#------------------------------------------------------
# Moko Underground OS Image Recipe
#------------------------------------------------------

IMAGE_LINGUAS = ""

ADD_INSTALL = "\
  fontconfig-utils \
  \
  ttf-dejavu-common \
  ttf-dejavu-sans \
  ttf-dejavu-serif \
  \
"  


IMAGE_INSTALL = "\
  ${MACHINE_TASK_PROVIDER} \
  netbase \
  sysfsutils \
  module-init-tools-depmod \
  rsync \
  screen \
  fbset \
  fbset-modes \
  \
  task-pyneo \
  \
  ${ADD_INSTALL} \
"

inherit image

ROOTFS_POSTPROCESS_COMMAND += 'date "+%m%d%H%M%Y" >${IMAGE_ROOTFS}/etc/timestamp'
