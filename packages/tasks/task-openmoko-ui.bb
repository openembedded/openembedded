DESCRIPTION = "Openmoko: GUI for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r73"

inherit task

XSERVER ?= "xserver-kdrive-fbdev"

#
# task-openmoko-ui
#
DESCRIPTION_task-openmoko-ui = "Openmoko: The X11/Gtk+2 based native User Interface"
PACKAGE_ARCH_task-openmoko-ui = "${MACHINE_ARCH}"
RDEPENDS_task-openmoko-ui = "\
  gdk-pixbuf-loader-png \
  gdk-pixbuf-loader-gif \
  gdk-pixbuf-loader-xpm \
  gdk-pixbuf-loader-jpeg \
  pango-module-basic-x \
  pango-module-basic-fc \
  gtk+ \
  matchbox-wm \
  ${XSERVER} \
  xserver-kdrive-common \
  xserver-nodm-init \
  xauth \
  xhost \
  xset \
  xrandr \
  \
  settings-daemon \
  notification-daemon \
  neod \
  libnotify \
  \
  openmoko-session2 \
  openmoko-sound-system2 \
  openmoko-sound-theme-standard2 \
  \
  gpe-scap \
"

# Handle theming. FIXME: properly use machine database in a smart way,
# taking into account not only size but also PPI! Ultimately this might
# need recomputing some theme files and images on-the-fly :/ SVG and logical
# theme description anyone? Or simply Edje to the rescue! :D
THEMES          = "openmoko-icon-theme-standard2      moko-gtk-engine"
THEMES_a780     = "openmoko-icon-theme-standard2-qvga openmoko-theme-standard2-qvga"
THEMES_e680     = "openmoko-icon-theme-standard2-qvga openmoko-theme-standard2-qvga"
THEMES_a1200    = "openmoko-icon-theme-standard2-qvga openmoko-theme-standard2-qvga"
THEMES_rokre2   = "openmoko-icon-theme-standard2-qvga openmoko-theme-standard2-qvga"
THEMES_rokre6   = "openmoko-icon-theme-standard2-qvga openmoko-theme-standard2-qvga"
THEMES_magician = "openmoko-icon-theme-standard2-qvga openmoko-theme-standard2-qvga"
THEMES_chumby   = "openmoko-icon-theme-standard2-qvga openmoko-theme-standard2-qvga"
THEMES_htcblueangel = "openmoko-icon-theme-standard2-qvga openmoko-theme-standard2-qvga"

RDEPENDS_task-openmoko-ui += "${THEMES}"
