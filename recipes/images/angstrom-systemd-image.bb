#Angstrom image to test systemd

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = " \
	busybox \
    bash-sh \
	dropbear \
	e2fsprogs-e2fsck \
	avahi-daemon avahi-utils \
    connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "tinylogin shadow"


inherit image
