require fso-zhone-image.bb

# no extra apps
GTK_INSTALL = ""
GAMES_INSTALL = ""
APP_INSTALL = ""

# fso+zhone
ZHONE_INSTALL = "\
  task-fso-compliance \
  paroli \
"
