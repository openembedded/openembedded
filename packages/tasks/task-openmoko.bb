DESCRIPTION = "OpenMoko: Tasks for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PROVIDES = "task-openmoko-everything"
PR = "r60"

inherit task

PACKAGES = "\
  task-openmoko-linux \
  task-openmoko-ui \
  task-openmoko-base \
  task-openmoko-phone \
  task-openmoko-pim \
  task-openmoko-net \
  \
  task-openmoko-games \
  task-openmoko-examples \
"

RDEPENDS_task-openmoko-everything := "\
  ${PACKAGES} \
  task-openmoko-debug \
  task-openmoko-native-sdk \
"

#
# task-openmoko-core
#
DESCRIPTION_task-openmoko-linux = "OpenMoko: Linux Core Services"
RDEPENDS_task-openmoko-linux = "\
  task-base \
  netbase \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
  rsync \
  screen \
  psplash \
#  update-alternatives \
"

#
# task-openmoko-ui
#
DESCRIPTION_task-openmoko-ui = "OpenMoko: The X11/Gtk+2 based native User Interface"
RDEPENDS_task-openmoko-ui = "\
  gdk-pixbuf-loader-png \
  gdk-pixbuf-loader-gif \
  gdk-pixbuf-loader-xpm \
  gdk-pixbuf-loader-jpeg \
  pango-module-basic-x \
  pango-module-basic-fc \
  gtk+ \
  libgtkstylus \
  libgtkinput \
  matchbox-common \
  matchbox-wm \
  xserver-kdrive-fbdev \
  xserver-kdrive-common \
  xserver-nodm-init \
#  x11-c-locale \
  ttf-bitstream-vera \
  xauth \
  xhost \
  xset \
  xrandr \
  settings-daemon \
  \
  openmoko-session2 \
  openmoko-sound-system \
  openmoko-sound-theme-standard \
  neod \
  gpe-scap \
"

# handle theming. FIXME: properly use machine database in a smart way,
# taking into account not only size but also PPI! Ultimately this might
# need recomputing some theme files and images on-the-fly :/ SVG and logical
# theme description anyone? Or simply Edje to the rescue! :D
THEMES        = "openmoko-icon-theme-standard2 openmoko-theme-standard2"
THEMES_a780   = "openmoko-icon-theme-standard2 openmoko-theme-standard2-qvga"
THEMES_e680   = "openmoko-icon-theme-standard2 openmoko-theme-standard2-qvga"
THEMES_a1200  = "openmoko-icon-theme-standard2 openmoko-theme-standard2-qvga"
THEMES_rokre2 = "openmoko-icon-theme-standard2 openmoko-theme-standard2-qvga"
THEMES_rokre6 = "openmoko-icon-theme-standard2 openmoko-theme-standard2-qvga"

RDEPENDS_task-openmoko-ui += "${THEMES}"

#
# task-openmoko-base
#
DESCRIPTION_task-openmoko-base = "OpenMoko: Main-Menu Launcher, Top Panel, and Footer"
RDEPENDS_task-openmoko-base = "\
  matchbox-panel-2 \
  matchbox-panel-2-applets \
  matchbox-applet-inputmanager \
#  openmoko-appmanager \
  matchbox-keyboard-inputmethod \
  matchbox-keyboard-im \
  matchbox-stroke \
  openmoko-terminal2 \
  openmoko-keyboard \
#  openmoko-panel-mainmenu \
  openmoko-panel-battery \
  openmoko-panel-bt \
  openmoko-panel-clock \
  openmoko-panel-usb \
  openmoko-panel-gps \
"

#
# task-openmoko-phone
#
DESCRIPTION_task-openmoko-phone = "OpenMoko: GSM and GPRS Phone Services"
RDEPENDS_task-openmoko-phone = "\
  gsmd \
  libgsmd-tools \
  openmoko-dialer2 \
  openmoko-panel-gsm \
#  ppp \
"

#
# task-openmoko-pim
#
DESCRIPTION_task-openmoko-pim = "OpenMoko: PIM Applications"
RDEPENDS_task-openmoko-pim = "\
  eds-dbus \
  openmoko-calculator2 \
  openmoko-contacts2 \
  openmoko-feedreader2 \
  openmoko-tasks2 \
  openmoko-today2 \
#  openmoko-messages \
"

#
# task-openmoko-net
#
DESCRIPTION_task-openmoko-net = "OpenMoko: Linux Advanced Networking"
RDEPENDS_task-openmoko-net = "\
  bluez-utils \
  bridge-utils \
"

#
# task-openmoko-games
#
DESCRIPTION_task-openmoko-games = "OpenMoko: Games"
RDEPENDS_task-openmoko-games = "\
  oh-puzzles \
"
