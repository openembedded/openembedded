DESCRIPTION = "Openmoko: Tasks for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
ALLOW_EMPTY = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
LICENSE = "MIT"
PR = "r0.01"

inherit task

PACKAGES = "task-openmoko-bare"

DESCRIPTION_task-openmoko-qtopia-x11 = "Openmoko: Provide Window Manager, Om-settings and Om-installer"
RDEPENDS_task-openmoko-bare = "\
           readline \
           connman \
           connman-plugin-connman-resolvconf \
           connman-plugin-connman-dhclient \
           connman-plugin-connman-80211 \
           connman-script-dhclient \
           libnotify \
# X

# illume-theme-asu should be first than illume
# to let opkg install illume-theme-asu first than illume-theme-freesmartphone
# then we have ASU theme but not FSO theme in default.
           illume-theme-asu \
           illume \
           e-wm \
           ${XSERVER} \
           xserver-kdrive-common \
           xserver-nodm-init \
           xauth \
           xhost \
           xset \
           xrandr \
# Om applications
           assassin \
           assassin-thumbnail \
           om-settings \
           openmoko-community-repository \
"
