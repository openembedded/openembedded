PACKAGES = task-dvb
DESCRIPTION = "Meta-package for DVB application"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
ALLOW_EMPTY = 1
PR = "r5"

RDEPENDS = "dvbstream dvbtune xserver-xorg tda1004x-firmware mythtv lirc lirc-modules drm-module-via"
DEPENDS = "dvbstream dvbtune xserver-xorg tda1004x-firmware mythtv lirc lirc-modules drm-kernel"
LICENSE = MIT
