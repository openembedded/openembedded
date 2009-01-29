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

GAMES_INSTALL = "\
	numptyphysics\
	scummvm\
	tichy\
	quake1\
"

# summary
IMAGE_INSTALL = "\
	${BASE_INSTALL}\
	${X_INSTALL}\
	${MEDIA_INSTALL}\
	${TOOLS_INSTALL}\
	zad\
"

inherit image

# perform some patches to the rootfs
rootfs_postprocess() {
	# image timastamp
	date "+%m%d%H%M%Y" > ${IMAGE_ROOTFS}/etc/timestamp
	# aliases
	touch ${IMAGE_ROOTFS}/etc/profile
	echo alias 'l="ls -l"' >> ${IMAGE_ROOTFS}/etc/profile
	echo alias 'll="ls -la"' >> ${IMAGE_ROOTFS}/etc/profile
	echo alias 'ipkg=opkg' >> ${IMAGE_ROOTFS}/etc/profile
	# nfs
	mkdir -p ${IMAGE_ROOTFS}/media/hostpc
	echo >> ${IMAGE_ROOTFS}/etc/fstab
	echo "# nfs to hostpc" >> ${IMAGE_ROOTFS}/etc/fstab
	echo "hostpc:/media/hostpc /media/hostpc nfs noauto,nolock,soft,rsize=32768,wsize=32768 0 0" >> ${IMAGE_ROOTFS}/etc/fstab
	# screen
	echo "startup_message off" >> ${IMAGE_ROOTFS}/home/root/.screenrc
	echo 'shell -$SHELL' >> ${IMAGE_ROOTFS}/home/root/.screenrc
	# keys
	ln -s /media/card/keys/ssh ${IMAGE_ROOTFS}/home/root/.ssh
	# bootup
	echo 'echo 0 0 0 0 > /proc/sys/kernel/printk' >> ${IMAGE_ROOTFS}/etc/init.d/rc
	echo 'touch /var/log/lastlog' >> ${IMAGE_ROOTFS}/etc/init.d/rc
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_postprocess"
