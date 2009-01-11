#------------------------------------------------------
# Rasterman Illume Image Recipe
#------------------------------------------------------

IMAGE_LINGUAS = "en-us de-de fr-fr pt-br ca-es zh-cn zh-tw bg-bg cs-cz da-dk nl-nl fi-fi hu-hu it-it ja-jp ko-kr nb-no pl-pl ru-ru sk-sk sl-si es-ar sv-se"

# getting the base system up
BASE_INSTALL = "\
  angstrom-libc-fixup-hack \
  ${MACHINE_TASK_PROVIDER} \
  task-base \
  netbase \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
#  prelink \
  exquisite \
  exquisite-themes \
  exquisite-theme-illume \
#  rsync \
#  screen \
#  fbset \
#  fbset-modes \
"

# Some machines don't set a *runtime* provider for X, so default to Xfbdev here
# virtual/xserver won't work, since the kdrive recipes will build multiple xserver packages
XSERVER ?= "xserver-kdrive-fbdev"

# getting an X window system up
X_INSTALL = "\
  glibc-charmap-utf-8 \
  e-wm \
  e-wm-config-illume \
  e-wm-config-standard \
  e-wm-config-netbook \
  e-wm-config-minimalist \
  e-wm-config-scaleable \
  ${XSERVER} \
  xserver-kdrive-splash-illume \
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
#  ttf-dejavu-serif \
  ttf-dejavu-sans-mono \
  ttf-arphic-uming \
  \
"

# useful command line tools
TOOLS_INSTALL = "\
#  bash \
  dosfstools \
#  iptables \
  lsof \
  mickeydbus \
  mickeyterm \
  mtd-utils \
  nano \
  powertop \
  s3c24xx-gpio \
  sysstat \
#  tcpdump \
"

# audio
AUDIO_INSTALL = "\
  alsa-oss \
  alsa-state \
  alsa-utils-aplay \
  alsa-utils-amixer \
  gst-meta-audio \
  ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugin-mad', d)} \
  gst-plugin-modplug \
  gst-plugin-sid \
  fso-sounds \
"

GTK_INSTALL = "\
#  openmoko-calculator2 \
  vala-terminal \
#  gpe-scap \
#  tangogps \
"

GAMES_INSTALL = "\
#  numptyphysics \
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
  fso-gsm0710muxd \
  frameworkd \
  fso-gpsd \
#  zhone \
"

# additional apps
APPS_INSTALL = "\
#  tichy \
#  gpe-gallery \
#  gpe-sketchbook \
#  gpe-filemanager \
#  vagalume \
#  starling \
   rxvt-unicode \
   gpe-terminal \
   elementary-alarm \
   gpe-scap \
   libefso \
   essential-dialer \
"

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${X_INSTALL} \
  ${GTK_INSTALL} \
  ${GAMES_INSTALL} \
  ${AUDIO_INSTALL} \
  ${TOOLS_INSTALL} \
  ${PYTHON_INSTALL} \
  ${ZHONE_INSTALL} \
  ${APPS_INSTALL} \
"
inherit image

# perform some convenience tweaks to the rootfs
fso_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    # date/time
    date "+%m%d%H%M%Y" >./etc/timestamp
    # alias foo
    echo "alias pico=nano" >>./etc/profile
#    echo "alias fso='cd /local/pkg/fso'" >>./etc/profile
    echo "alias ipkg='opkg'" >>./etc/profile
    # dns
    echo "nameserver 208.67.222.222" >>./etc/resolv.conf
    echo "nameserver 208.67.220.220" >>./etc/resolv.conf
    # nfs
    mkdir -p ./local/pkg
    echo >>./etc/fstab
#    echo "# NFS Host" >>./etc/fstab
#    echo "192.168.0.200:/local/pkg /local/pkg nfs noauto,nolock,soft,rsize=32768,wsize=32768 0 0" >>./etc/fstab
    # fix .desktop files for illume
    desktop=`find ./usr/share/applications -name "*.desktop"`
    for file in $desktop; do
        echo "Categories=Office;" >>$file
    done
    # minimal gtk theme foo
    mkdir -p ./etc/gtk-2.0/
    echo 'gtk-font-name = "Sans 5"' >> ./etc/gtk-2.0/gtkrc
    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "fso_rootfs_postprocess"
