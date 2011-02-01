#Angstrom bootstrap at91sam9 image

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

ANGSTROM_EXTRA_INSTALL += " \
	alsa-utils-amixer \
	alsa-utils-aplay \
	dosfstools \
	iperf \
	madplay \
	mplayer \
	mtd-utils \
#	nbench-byte \
	owl-wifi \
	thttpd \
	usbview \
	"

DEPENDS = "task-base-extended \
           ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)} \
	   "

IMAGE_INSTALL = "task-base-extended \
	    ${ANGSTROM_EXTRA_INSTALL} \
	    ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)} \
	   "

export IMAGE_BASENAME = "console-at91sam9-image"
IMAGE_LINGUAS = ""

#we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND += "rm -f ${IMAGE_ROOTFS}/boot/*Image*; "

inherit image

