#------------------------------------------------------
# Rasterman Illume Image Recipe
#------------------------------------------------------

IMAGE_LINGUAS = "en-us de-de fr-fr pt-br ca-es zh-cn zh-tw bg-bg cs-cz da-dk nl-nl fi-fi hu-hu it-it ja-jp ko-kr nb-no pl-pl ru-ru sk-sk sl-si es-ar sv-se"

# use exquisite splash
SPLASH = "exquisite exquisite-themes exquisite-theme-illume"

# getting the base system up
BASE_INSTALL = "\
  angstrom-libc-fixup-hack \
  ${MACHINE_TASK_PROVIDER} \
  task-base \
  netbase \
  sysfsutils \
  wireless-tools \
  modutils-initscripts \
  module-init-tools-depmod \
  pointercal \
  tslib-conf \
#  prelink \
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
  libx11-locale \
  localedef \
  glibc-charmap-utf-8 \
  shared-mime-info \
  mime-support \
  e-wm \
  e-wm-sysactions \
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
  ttf-dejavu-serif \
  ttf-dejavu-sans-mono \
  ttf-arphic-uming \
"
DEV_INSTALL = "\
  task-native-sdk \
  e-wm-dev \
  task-proper-tools \
  ntpdate \
  nfs-utils-client \
  gdb \
  pkgconfig \
  ltrace \
  perl-module-file-path \
"

# useful command line tools
TOOLS_INSTALL = "\
  dosfstools \
  lsof \
  mdbus \
  mtd-utils \
  nano \
  powertop \
  sysstat \
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
#  fso-sounds \
"

GTK_INSTALL = "\
  vala-terminal \
  gpe-scap \
"

# FIXME these should rather be part of alsa-state,
# once Om stabilizes them...
AUDIO_INSTALL_append_om-gta01 = "openmoko-alsa-scenarios"
AUDIO_INSTALL_append_om-gta02 = "openmoko-alsa-scenarios"

# GLES libs - put them on if the platform has them
GLES_INSTALL = ""
GLES_INSTALL_append_beagleboard  = "libgles-omap3 devmem2"
GLES_INSTALL_append_omap-3430sdp = "libgles-omap3"
GLES_INSTALL_append_omap-3430ldp = "libgles-omap3"
GLES_INSTALL_append_omap3evm     = "libgles-omap3"
#GLES_INSTALL_append_overo        = "libgles-omap3"
GLES_INSTALL_append_mx31ads      = "libgles-mx31"
GLES_INSTALL_append_mx31litekit  = "libgles-mx31"
GLES_INSTALL_append_zylonite     = "libgles-zylonite"

# python
PYTHON_INSTALL = "\
#  task-python-efl \
#  python-codecs \
#  python-gst \
"

# zhone
ZHONE_INSTALL = "\
  fso-gsm0710muxd \
  frameworkd \
  fso-gpsd \
  zhone \
"

# additional apps
APPS_INSTALL = "\
   elementary-alarm \
   expedite \
   expedite-themes \
#   libefso \
#   essential-dialer \
#   elementary-sms \
"

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${GLES_INSTALL} \
  ${X_INSTALL} \
  ${GTK_INSTALL} \
  ${AUDIO_INSTALL} \
  ${TOOLS_INSTALL} \
  ${PYTHON_INSTALL} \
#  ${ZHONE_INSTALL} \
  ${APPS_INSTALL} \
  ${DEV_INSTALL} \
  ${SPLASH} \
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
