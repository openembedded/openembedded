# Angstrom x11-gpe-image with additional apps included
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-tslib \
           xf86-video-fbdev "

require x11-gpe-image.bb

export IMAGE_BASENAME = "x11-at91sam9-image"

DEPENDS = "task-base"

IMAGE_INSTALL += "\
	gpe-calculator \
	gpe-calendar \
	gpe-clock \
	gpe-contacts \
	gpe-edit \
	gpe-filemanager \
	gpe-gallery \
	gpe-go \
	gpe-irc \
	gpe-mixer \
	gpe-scap \
	gpe-sketchbook \
	gpe-terminal \
	gpe-tetris \
	gpe-watch \
	gpe-windowlist \
	gnome-mplayer \
	matchbox-panel-hacks \
	usbview \
	mplayer \
	thttpd \
	madplay \
	alsa-utils-aplay \
	alsa-utils-amixer \
	iperf \
	fbv \
	dosfstools \
	mtd-utils \
	gpe-mini-browser \
	tslib-conf \
	tslib-calibrate \
	tslib-tests \
	libstdc++ \
	${IMAGE_EXTRA_INSTALL} \
#	nbench-byte \
#	pointercal \
	"

# IMAGE_LINGUAS += " se no dk fi"
ROOTFS_POSTPROCESS_COMMAND += "set_image_autologin; "
ROOTFS_POSTPROCESS_COMMAND += "install_linguas; "

#we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND += "rm -f ${IMAGE_ROOTFS}/boot/*Image*; "

