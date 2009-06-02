require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- displaylink driver"

RRECOMMENDS_${PN} = "kernel-module-udlfb"

SRC_URI = "http://projects.unbit.it/downloads/xf86-video-displaylink-${PV}.tar.gz"

# It's a tar.bz2 file :(
do_unpack() {
	mkdir -p ${WORKDIR}
	cd ${WORKDIR}
	bzcat ${DL_DIR}/xf86-video-displaylink-${PV}.tar.gz | tar xf -
}

S = "${WORKDIR}/${PN}"
