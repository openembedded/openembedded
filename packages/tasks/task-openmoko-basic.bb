DESCRIPTION = "Openmoko: Tasks for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
ALLOW_EMPTY = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
LICENSE = "MIT"
PR = "r0.04"

inherit task

PACKAGES = "task-openmoko-basic"

DESCRIPTION_task-openmoko-qtopia-x11 = "Openmoko: Provide Window Manager, Om-settings and Om-installer"
RDEPENDS_task-openmoko-basic = "\
           readline \
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
           libnotify \
# X

# illume-theme-asu should be first than illume
# to let opkg install illume-theme-asu first than illume-theme-freesmartphone
# then we have ASU theme but not FSO theme in default.
           illume-theme-asu \
           illume-theme-illume \
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
