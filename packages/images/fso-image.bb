#------------------------------------------------------
# freesmartphone.org Image Recipe
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
 
MICKEY_INSTALL = "\
  htop \
  mickeyterm \
  nano \
  powertop \
  s3c24xx-gpio \
"
 
ZHONE_INSTALL = "\
  gsm0710muxd \
  python-odeviced \
  python-oeventd \
  python-ophoned \
  python-ousaged \
  zhone \
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
  matchbox-wm \
  ${XSERVER} \
  xserver-kdrive-common \
  xserver-nodm-init \
  xauth \
  xhost \
  xset \
  xrandr \
  \
  python-codecs \
  \
  openmoko-alsa-scenarios \
  openmoko-sound-system2 \
  openmoko-sound-theme-standard2 \
  \
  ${ADD_INSTALL} \
  ${MICKEY_INSTALL} \
  ${ZHONE_INSTALL} \
"
 
inherit image
 
ROOTFS_POSTPROCESS_COMMAND += 'date "+%m%d%H%M%Y" >${IMAGE_ROOTFS}/etc/timestamp'

