# This image is intended to be the base for further neuros images

inherit image

export IMAGE_BASENAME = "Neuros-OSD2-base-image"

PR = "r1"

# Select which Secure Shell Daemon gets included into the rootfs
DISTRO_SSH_DAEMON ?= "dropbear"
DISTRO_DEV_MANAGER = "mdev"
PREFERRED_PROVIDER_hotplug = "mdev"

# Include a timestamp that initscripts can use to set the time to a 
# more sane value after a reboot  
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = "task-boot \
                 util-linux-mount util-linux-umount \
                 e2fsprogs dosfstools \
                 wireless-tools zd1211-firmware \
                 ${DISTRO_SSH_DAEMON} \
                 qt-embedded dbus \
                 neuros-mainmenu \
                 neuros-nwm \
#                 vlc-davinci \
                "

IMAGE_LINGUAS = ""
