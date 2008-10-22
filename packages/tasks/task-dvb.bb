DESCRIPTION = "Meta-package for DVB application"
PR = "r6"

inherit task

RDEPENDS_${PN} = "dvbstream dvbtune xserver-xorg tda1004x-firmware mythtv lirc lirc-modules drm-module-via"

LICENSE = "MIT"

# there is a -march=586 somewhere in the source tree of mythtv
COMPATIBLE_HOST = 'i.86.*-linux'
