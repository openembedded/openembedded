#Angstrom X11 at91sam9 image

XSERVER ?= ""
	
ANGSTROM_EXTRA_INSTALL += " \
	gpe-irc \
	gpe-sketchbook \
	gpe-filemanager \
	gpe-tetris \
	gpe-go \
	gpe-calendar \
	gpe-contacts \
	gpe-edit \
	gpe-gallery \
	gpe-calculator \
	gpe-clock \
	gpe-terminal \
	gpe-watch \
	matchbox-panel-hacks \
	gpe-scap \
	gpe-windowlist \
	gpe-mixer \
	usbview \
	mplayer \
	thttpd \
	madplay \
	alsa-utils-aplay \
	alsa-utils-amixer \
	iperf \
	dosfstools \
	mtd-utils \
#	nbench-byte \
	gpe-mini-browser \
	pointercal \
	gstreamer \
	gst-plugins-base \
	gst-plugins-good \
	gst-plugins-bad \
	gst-plugins-ugly \
	gst-plugin-avi \
	gst-plugin-mpegstream \
	gst-plugin-qtdemux \
	gst-plugin-mpegvideoparse \
	gst-plugin-asf \
	gst-plugin-alsa \
	gst-plugin-ossaudio \
	gst-plugin-audioresample \
	gst-plugin-audioconvert \
	gst-plugin-ximagesink \
	gst-plugin-fbdevsink \
	gst-plugin-faad \
	gst-plugin-mad \    
	gst-plugin-playbin \
	gst-plugin-decodebin \
	gst-plugin-typefindfunctions \
	gst-ffmpeg \
	gst-plugin-on2-8170 \
	on2-8170-libs \
	owl-wifi \
	"

export IMAGE_BASENAME = "x11-at91sam9m10-image"

DEPENDS = "task-base"
IMAGE_INSTALL = "\
    ${XSERVER} \
    task-base-extended \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    ${ANGSTROM_EXTRA_INSTALL}"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

at91sam9m10_rootfs_postprocess() {
   curdir=$PWD
   cd ${IMAGE_ROOTFS}

   # add init script to cratee hantro modules /dev files
   echo 'MAJOR=`cat /proc/devices |grep hx170|cut -f1 -d\ `' >> ${IMAGE_ROOTFS}//etc/init.d/hantro
   echo 'mknod /dev/hx170 c $MAJOR 0' >> ${IMAGE_ROOTFS}/etc/init.d/hantro
   echo 'MAJOR=`cat /proc/devices |grep memalloc|cut -f1 -d\ `' >> ${IMAGE_ROOTFS}//etc/init.d/hantro
   echo 'mknod /dev/memalloc c $MAJOR 0' >> ${IMAGE_ROOTFS}/etc/init.d/hantro
   chmod a+x  ${IMAGE_ROOTFS}/etc/init.d/hantro
   cd ${IMAGE_ROOTFS}/etc/rc5.d
   ln -s ../init.d/hantro S51hantro

   # back on track
   cd $curdir
}

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'
ROOTFS_POSTPROCESS_COMMAND += "set_image_autologin; "

#we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND += "rm -f ${IMAGE_ROOTFS}/boot/*Image*; "

#load sam9m10 vdec modules and create file descriptor at boot
ROOTFS_POSTPROCESS_COMMAND += "at91sam9m10_rootfs_postprocess; "

inherit image
