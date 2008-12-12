# pyneo image recipe

IMAGE_LINGUAS = "\
"

# base system
BASE_INSTALL = "\
	${MACHINE_TASK_PROVIDER}\
	netbase\
	sysfsutils\
	module-init-tools-depmod\
	rsync\
	screen\
	fbset\
	fbset-modes\
"

# getting an X window system up
X_INSTALL = "\
	${XSERVER}\
	matchbox-wm\
	xserver-kdrive-common\
	xserver-nodm-init\
	xauth\
	xhost\
	xset\
	xrandr\
	fontconfig-utils\
	ttf-dejavu-common\
	ttf-dejavu-sans\
	ttf-dejavu-serif\
"

# useful command line tools
TOOLS_INSTALL = "\
	dosfstools\
	iptables\
	lsof\
	mtd-utils\
	s3c24xx-gpio\
	sysstat\
"

# media audio/video
MEDIA_INSTALL = "\
	alsa-oss\
	alsa-state\
	alsa-utils-aplay\
	alsa-utils-amixer\
	gst-meta-audio\
	gst-plugin-mad\
	gst-plugin-modplug\
	gst-plugin-sid\
	openmoko-alsa-scenarios\
	mplayer\
"

# summary
IMAGE_INSTALL = "\
	${BASE_INSTALL}\
	${X_INSTALL}\
	${MEDIA_INSTALL}\
	${TOOLS_INSTALL}\
	euphony\
	epydial\
"

inherit image

# perform some patches to the rootfs
rootfs_postprocess() {
	# image timastamp
	date "+%m%d%H%M%Y" > ${IMAGE_ROOTFS}/etc/timestamp
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_postprocess"
