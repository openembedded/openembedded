require fso-image.inc

ILLUME_THEME = "paroli"

BASE_INSTALL += " \
#  udev-static-devices \
"

# not many extra apps
GTK_INSTALL = " \
   vala-terminal \
"

GAMES_INSTALL = ""
APPS_INSTALL = ""

# fso
ZHONE_INSTALL = "\
  paroli \
  paroli-theme \
  paroli-sounds \
  paroli-autostart \
  task-fso-compliance \
"
