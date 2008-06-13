# This image is intended to be the base for further neuros images

# Select which Secure Shell Daemon gets included into the rootfs
DISTRO_SSH_DAEMON ?= "dropbear"

# Include a timestamp that initscripts can use to set the time to a 
# more sane value after a reboot  
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = "task-boot \
                 util-linux-mount util-linux-umount \
                 ${DISTRO_SSH_DAEMON} \
	         "

IMAGE_LINGUAS = ""

inherit image

