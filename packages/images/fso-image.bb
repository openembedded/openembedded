#------------------------------------------------------
# freesmartphone.org Image Recipe
#------------------------------------------------------

PV = "1.1"
PR = "r0"

# no languages for now
IMAGE_LINGUAS = ""

BASE_INSTALL = "\
  task-base \
"

ILLUME_THEME = "illume-theme-freesmartphone"

X_INSTALL = "\
  task-x11-illume \
  task-fonts-truetype-core \
"

X_INSTALL_append_om-gta02 = "\
  task-fonts-truetype-chinese \
  task-fonts-truetype-japanese \
"

# tools
TOOLS_INSTALL = "\
  task-cli-tools \
  task-cli-tools-python \
"

# audio
AUDIO_INSTALL = "\
  alsa-oss \
  alsa-state \
  alsa-utils-aplay \
  alsa-utils-amixer \
  gst-meta-audio \
  gst-plugin-modplug \
  gst-plugin-sid \
  ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugin-mad', d)} \
  fso-sounds \
"

GTK_INSTALL = "\
  hicolor-icon-theme \
  tango-icon-theme \
  openmoko-calculator2 \
  vala-terminal \
  gpe-scap \
  tangogps \
"

GAMES_INSTALL = "\
  numptyphysics \
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

# fso+zhone
ZHONE_INSTALL = "\
  task-fso-compliance \
  zhone \
"

# additional apps
APPS_INSTALL = "\
  tichy \
  gpe-gallery \
  gpe-sketchbook \
  gpe-filemanager \
  vagalume \
  starling \
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

# perform some convenience tweaks to the rootfs to improve the out-of-the-box experience :M:
fso_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    # date/time
    date "+%m%d%H%M%Y" >./etc/timestamp
    # alias foo
    echo "alias pico=nano" >>./etc/profile
    echo "alias fso='cd /local/pkg/fso'" >>./etc/profile
    echo "alias ipkg='opkg'" >>./etc/profile
    # nfs
    mkdir -p ./local/pkg
    echo >>./etc/fstab
    echo "# NFS Host" >>./etc/fstab
    echo "192.168.0.200:/local/pkg /local/pkg nfs noauto,nolock,soft,rsize=32768,wsize=32768 0 0" >>./etc/fstab
    # fix .desktop files for illume
    desktop=`find ./usr/share/applications -name "*.desktop"`
    for file in $desktop; do
        echo "Categories=Office;" >>$file
    done
    # minimal gtk theme foo
    mkdir -p ./etc/gtk-2.0/
    echo 'gtk-font-name = "Sans 5"' >> ./etc/gtk-2.0/gtkrc
    echo 'gtk-icon-theme-name = "Tango"' >> ./etc/gtk-2.0/gtkrc
    # fix strange iconv/gconf bug
    ln -s libc.so.6 ./lib/libc.so
    # set sensible DNS entries
    echo "nameserver 208.67.222.222" > ./etc/resolv.conf
    echo "nameserver 208.67.220.220" >> ./etc/resolv.conf
    # back on track
    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "fso_rootfs_postprocess"
