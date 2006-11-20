PACKAGES = "${PN}"
DESCRIPTION = "Meta-package for MythTV diskless frontend"
ALLOW_EMPTY = "1"
PR = "r6"

RDEPENDS = "xserver-xorg mythtv lirc lirc-modules drm-module-via ttf-bitstream-vera fontconfig-utils setserial snes9x ntp mythfront-config gpe-dm mythfront-session bootlogd drm-module-drm"

LICENSE = "MIT"

# there is a -march=586 somewhere in the source tree of mythtv
COMPATIBLE_HOST = 'i.86.*-linux'
