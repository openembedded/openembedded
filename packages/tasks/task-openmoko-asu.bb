DESCRIPTION = "Openmoko: Om 2008.8 August Software Update"

SECTION = "openmoko/base"
ALLOW_EMPTY = "1"
LICENSE = "MIT"
PR = "r3"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = "task-openmoko-asu"
RDEPENDS_task-openmoko-asu = "\
  bluez-hcidump \
  readline \
  connman \
  connman-plugin-connman-resolvconf \
  connman-plugin-connman-dhclient \
  connman-plugin-connman-80211 \
  connman-script-dhclient \
  task-x11-illume \
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
"

RDEPENDS_task-openmoko-asu_append_om-gta02 = "\
  connman \
  connman-plugin-dhclient \
  connman-plugin-hal \
  connman-plugin-ipv4 \
  connman-plugin-netdev \
  connman-plugin-resolvconf \
  connman-plugin-resolvfile \
  connman-plugin-rtnllink \
  connman-plugin-wifi \
  connman-script-dhclient \
  pyefl-sudoku \
  \
# For supporting the om2007.2 stack
  openmoko-icon-theme-standard2 \
  moko-gtk-engine \
  settings-daemon \
  openmoko-asu-om20072-support \
"
