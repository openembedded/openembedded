# Angstrom bootstrap at91sam9 image
require console-base-image.bb

export IMAGE_BASENAME = "console-at91sam9-image"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

DEPENDS = "task-base-extended \
           ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)} \
	   "

IMAGE_INSTALL = "task-base-extended \
	usbview \
	mplayer \
	thttpd \
	madplay \
	alsa-utils-aplay \
	alsa-utils-amixer \
	iperf \
	dosfstools \
	mtd-utils \
	${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)} \
	${IMAGE_EXTRA_INSTALL} \
#	nbench-byte \
	"

IMAGE_LINGUAS = ""

#we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND += "rm -f ${IMAGE_ROOTFS}/boot/*Image*; "

inherit image

