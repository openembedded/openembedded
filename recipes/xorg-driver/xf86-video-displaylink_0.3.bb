require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- displaylink driver"

RRECOMMENDS_${PN} = "kernel-module-udlfb"

SRC_URI = "http://projects.unbit.it/downloads/udlfb-0.2.3_and_xf86-video-displaylink-${PV}.tar.gz \
           file://xf86-video-displaylink-0.3-xorg-abi-fix.patch;patch=1 \
"

S = "${WORKDIR}/${PN}"
