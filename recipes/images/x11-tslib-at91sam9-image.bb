# Angstrom x11-gpe-image with additional apps included
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-tslib \
           xf86-video-fbdev "

require x11-gpe-image.bb

# SPLASH = "exquisite exquisite-themes exquisite-theme-angstrom"

export IMAGE_BASENAME = "x11-xorg-at91sam9-image"

DEPENDS = "task-base"

IMAGE_INSTALL += "\
	alsa-utils-alsactl \
	alsa-utils-alsamixer \
	alsa-utils-amixer \
	alsa-utils-aplay \
	bash-sh \
	dosfstools \
	fbv \
	gnome-mplayer \
	gpe-calculator \
	gpe-calendar \
	gpe-clock \
	gpe-contacts \
	gpe-edit \
	gpe-filemanager \
	gpe-gallery \
	gpe-go \
	gpe-irc \
#	gpe-mini-browser2 \
	gpe-mixer \
	gpe-scap \
	gpe-sketchbook \
	gpe-terminal \
	gpe-tetris \
	gpe-watch \
	gpe-windowlist \
#	gstreamer \
#	gst-plugins-base \
#	gst-plugins-good \
#	gst-plugins-bad \
#	gst-plugins-ugly \
#	gst-plugin-avi \
#	gst-plugin-mpegstream \
#	gst-plugin-qtdemux \
#	gst-plugin-mpegvideoparse \
#	gst-plugin-asf \
#	gst-plugin-alsa \
#	gst-plugin-ossaudio \
#	gst-plugin-audioresample \
#	gst-plugin-audioconvert \
#	gst-plugin-ximagesink \
#	gst-plugin-fbdevsink \
#	gst-plugin-faad \
#	gst-plugin-mad \
#	gst-plugin-playbin \
#	gst-plugin-decodebin \
#	gst-plugin-typefindfunctions \
#	gst-ffmpeg \
	iperf \
	libstdc++ \
	madplay \
	matchbox-panel-hacks \
	mplayer \
	mtd-utils \
	nano \
	owl-wifi \
	pointercal \
#	thttpd \
	tslib-conf \
	tslib-calibrate \
	tslib-tests \
#	nbench-byte \
	usbview \
	${ANGSTROM_EXTRA_INSTALL} \
#	${IMAGE_EXTRA_INSTALL} \
	"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

# IMAGE_LINGUAS += " se no dk fi"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'
ROOTFS_POSTPROCESS_COMMAND += "set_image_autologin; "
ROOTFS_POSTPROCESS_COMMAND += "install_linguas; "

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
