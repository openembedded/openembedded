PACKAGES = "${PN}"
DESCRIPTION = "Meta-package for MythTV diskless frontend"
ALLOW_EMPTY = "1"
PR = "r13"

RDEPENDS = "xserver-xorg mythtv-frontend mythtv-filters mythtv-theme-g.a.n.t. mythtv-theme-default lirc lirc-modules ttf-bitstream-vera fontconfig-utils setserial snes9x ntp mythfront-config gpe-dm mythfront-session bootlogd font-cursor-misc font-misc-misc xf86-input-keyboard xf86-input-mouse"

RDEPENDS_append_epia = " xorg-driver-via mesa-dri-driver-unichrome"

LICENSE = "MIT"

# there is a -march=586 somewhere in the source tree of mythtv
COMPATIBLE_HOST = 'i.86.*-linux'
