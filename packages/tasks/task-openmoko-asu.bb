DESCRIPTION = "Openmoko: Om 2008.8 August Software Update"

SECTION = "openmoko/base"
ALLOW_EMPTY = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
LICENSE = "MIT"
PR = "r2.02"

inherit task

PACKAGES = "task-openmoko-asu"
RDEPENDS_task-openmoko-asu = "\
  bluez-hcidump \
  readline \
  connman \
  connman-plugin-connman-resolvconf \
  connman-plugin-connman-dhclient \
  connman-plugin-connman-80211 \
  connman-script-dhclient \
  e-wm \
  illume \
  illume-theme \
  assassin \
  diversity-daemon \
  om-locations \
  om-maps-low-levels \
  ${XSERVER} \
  xserver-kdrive-common \
  xserver-nodm-init \
  xauth \
  xhost \
  xset \
  xrandr \
  libnotify \
  om-settings \
  etk-theme-ninja \
  openmoko-community-repository \
  assassin-thumbnail \
  pyefl-sudoku \
  \
# For supporting the om2007.2 stack
  openmoko-icon-theme-standard2 \
  moko-gtk-engine \
  settings-daemon \
  openmoko-asu-om20072-support \
"
