#------------------------------------------------------
# freesmartphone.org Image Recipe
#------------------------------------------------------

IMAGE_LINGUAS = ""

# getting the base system up
BASE_INSTALL = "\
  ${MACHINE_TASK_PROVIDER} \
  netbase \
  sysfsutils \
  module-init-tools-depmod \
  rsync \
  screen \
  fbset \
  fbset-modes \
"

# getting an X window system up
X_INSTALL = "\
  matchbox-wm \
  ${XSERVER} \
  xserver-kdrive-common \
  xserver-nodm-init \
  xauth \
  xhost \
  xset \
  xrandr \
  \
  fontconfig-utils \
  \
  ttf-dejavu-common \
  ttf-dejavu-sans \
  ttf-dejavu-serif \
  \
"

# useful command line tools
TOOLS_INSTALL = "\
#  bash \
  htop \
  mickeyterm \
  mplayer \
  nano \
  powertop \
  s3c24xx-gpio \
"

# audio
AUDIO_INSTALL = "\
  alsa-oss \
  alsa-state \
  alsa-utils-aplay \
  gst-meta-audio \
  gst-plugin-mad \
  gst-plugin-modplug \
  gst-plugin-sid \
  fso-sounds \
"

# FIXME these should rather be part of alsa-state,
# once Om stabilizes them...
AUDIO_INSTALL_append_om-gta01 = "\
  openmoko-alsa-scenarios \
"
AUDIO_INSTALL_append_om-gta02 = "\
  openmoko-alsa-scenarios \
"

# python
PYTHON_INSTALL = "\
  task-python-efl \
  python-codecs \
  python-gst \
"

# zhone
ZHONE_INSTALL = "\
  gsm0710muxd \
  python-odeviced \
  python-oeventd \
  python-ophoned \
  python-ousaged \
  zhone \
"

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${X_INSTALL} \
  ${AUDIO_INSTALL} \
  ${TOOLS_INSTALL} \
  ${PYTHON_INSTALL} \
  ${ZHONE_INSTALL} \
"

inherit image

# perform some convenience tweaks to the rootfs
mickey_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    date "+%m%d%H%M%Y" >./etc/timestamp
    echo "alias pico=nano" >>./etc/profile
    echo "alias fso='cd /local/pkg/fso'" >>./etc/profile
    echo "alias ipkg='opkg'" >>./etc/profile
    mkdir -p ./local/pkg
    echo >>./etc/fstab
    echo "# NFS Host" >>./etc/fstab
    echo "192.168.0.200:/local/pkg /local/pkg nfs noauto,nolock,soft,rsize=32768,wsize=32768 0 0" >>./etc/fstab
    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "mickey_rootfs_postprocess"
