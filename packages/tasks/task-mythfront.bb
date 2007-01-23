PACKAGES = "${PN}"
DESCRIPTION = "Meta-package for MythTV diskless frontend"
ALLOW_EMPTY = "1"
PR = "r8"

RDEPENDS = "xserver-xorg mythtv-frontend mythtv-filters mythtv-theme-g.a.n.t. mythtv-theme-default lirc lirc-modules ttf-bitstream-vera fontconfig-utils setserial snes9x ntp mythfront-config gpe-dm mythfront-session bootlogd drm-module-drm xf86-input-evdev"

RDEPENDS_append_epia = " xf86-video-via drm-module-via"

LICENSE = "MIT"

# there is a -march=586 somewhere in the source tree of mythtv
COMPATIBLE_HOST = 'i.86.*-linux'
