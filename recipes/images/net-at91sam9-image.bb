#Angstrom network centric at91sam9 image

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

ANGSTROM_EXTRA_INSTALL += " \
	madplay \
	alsa-utils-aplay \
	alsa-utils-amixer \
	alsa-utils-alsamixer \
	alsa-utils-alsactl \
	iperf \
	dosfstools \
	mtd-utils \
	bash-sh \
	mplayer \
	iproute2 \
	iptables \
	bridge-utils \
	canutils \
	"

DEPENDS = "task-base-extended \
           ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)} \
	   "

IMAGE_INSTALL = "task-base-extended \
	    ${ANGSTROM_EXTRA_INSTALL} \
	    ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)} \
	   "

export IMAGE_BASENAME = "net-at91sam9-image"
IMAGE_LINGUAS = ""

#we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND += "rm -f ${IMAGE_ROOTFS}/boot/*Image*; "

at91sam9_rootfs_postprocess() {
	curdir=$PWD
	cd ${IMAGE_ROOTFS}

	# bash-sh: pkg_postinst_bash command shall be run again
	# (overloaded by busybox shell)
	cd bin
	ln -sf bash sh

	cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "at91sam9_rootfs_postprocess; "

inherit image

