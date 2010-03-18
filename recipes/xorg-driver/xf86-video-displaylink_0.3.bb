require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- displaylink driver"

RRECOMMENDS_${PN} = "kernel-module-udlfb"

SRC_URI = "http://projects.unbit.it/downloads/udlfb-0.2.3_and_xf86-video-displaylink-${PV}.tar.gz;name=archive \
           file://xf86-video-displaylink-0.3-xorg-abi-fix.patch;patch=1 \
"

S = "${WORKDIR}/${PN}"
SRC_URI[archive.md5sum] = "c2aedc8130c2e4d52e334b6804ab70da"
SRC_URI[archive.sha256sum] = "487a1d7bf4b896d9a4b9e7dd1bd293adcadde5684fe9fe32aa209761c3191b3e"
