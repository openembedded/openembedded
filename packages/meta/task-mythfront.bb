PACKAGES = "${PN}"
DESCRIPTION = "Meta-package for MythTV diskless frontend"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
ALLOW_EMPTY = 1
PR = "r4"

RDEPENDS = "xserver-xorg mythtv lirc lirc-modules drm-module-via ttf-bitstream-vera libfontconfig-utils setserial snes9x ntp snes232 linux-input mythfront-config gpe-dm mythfront-session"
DEPENDS = "xserver-xorg mythtv lirc lirc-modules drm-kernel ttf-bitstream-vera setserial snes9x ntp snes232 linux-input mythfront-config gpe-dm mythfront-session"
LICENSE = MIT
