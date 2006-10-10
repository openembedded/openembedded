PACKAGES = task-dvb
DESCRIPTION = "Meta-package for DVB application"
ALLOW_EMPTY = 1
PR = "r5"

RDEPENDS = "dvbstream dvbtune xserver-xorg tda1004x-firmware mythtv lirc lirc-modules drm-module-via"

LICENSE = MIT

# there is a -march=586 somewhere in the source tree of mythtv
COMPATIBLE_HOST = 'i.86.*-linux'
