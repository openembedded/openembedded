require fso-image.inc

ILLUME_THEME = "paroli"

BASE_INSTALL += " \
#  udev-static-devices \
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

