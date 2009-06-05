require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- displaylink driver"

RRECOMMENDS_${PN} = "kernel-module-udlfb"

SRC_URI = "http://projects.unbit.it/downloads/xf86-video-displaylink_and_udlfb.tar.gz"

S = "${WORKDIR}/${PN}"
