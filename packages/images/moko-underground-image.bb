#------------------------------------------------------
# Moko Underground OS Image Recipe
#------------------------------------------------------

IMAGE_LINGUAS = ""

IMAGE_INSTALL = "\
  ${MACHINE_TASK_PROVIDER} \
  task-base \
  netbase \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
  rsync \
  screen \
  fbset \
  fbset-modes \
  \
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

DEPENDS = "\
  ${MACHINE_TASK_PROVIDER} \
  task-pyneo \
"


inherit image

ROOTFS_POSTPROCESS_COMMAND += 'date "+%m%d%H%M%Y" >${IMAGE_ROOTFS}/etc/timestamp'
