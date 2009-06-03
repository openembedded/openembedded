require fso-image.inc

ILLUME_THEME = "paroli"

BASE_INSTALL += " \
#  udev-static-devices \
  locale-base-en-ca \
  libx11-locale \
  localedef \
"

# not many extra apps
GTK_INSTALL = " \
   vala-terminal \
"

GAMES_INSTALL = ""
APPS_INSTALL = ""

PAROLI_INSTALL = "\
  paroli \
  paroli-theme \
  paroli-sounds \
  paroli-autostart \
  task-fso-compliance \
"

PYTHON_INSTALL = "\
  python-evas \
  python-ecore \
  python-edje \
  python-emotion \
  python-etk \
  python-epsilon \
  python-edbus \
  python-codecs \
  python-gst \
"

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${X_INSTALL} \
  ${GTK_INSTALL} \
  ${GAMES_INSTALL} \
  ${AUDIO_INSTALL} \
  ${TOOLS_INSTALL} \
  ${PYTHON_INSTALL} \
  ${PAROLI_INSTALL} \
  ${APPS_INSTALL} \
"

paroli_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    # set a default locale    
    echo "export LC_ALL=en_CA.utf-8" >>./etc/profile
    cd $curdir

    # nuke bad bluetooth file - figure this out on monday
    rm ./etc/dbus-1/system.d/bluetooth.conf
}

ROOTFS_POSTPROCESS_COMMAND += "paroli_rootfs_postprocess;"
