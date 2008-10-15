#Angstrom SDR image
# An image with tools for software defined radio and unicorn radio

# TODO: 
# X demo
# xorg.conf

PR = "r3"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

# Also generate tar.bz2 images for use on e.g. SD or nfsroot
IMAGE_FSTYPES += "tar.bz2"

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"
XSERVER ?= "xserver-kdrive-fbdev"

# Install "big" X if the target has a screen
GUIPACKAGES_BIGX = " \
        xf86-input-evdev \
        xf86-input-mouse \
        xf86-video-dummy \
        xf86-video-fbdev \
        ${@base_contains("COMBINED_FEATURES", "usbhost", "xf86-video-sisusb", "",d)} \
        xf86-video-vesa \
"

GUIPACKAGES = " \
	${XSERVER} \
	angstrom-x11-base-depends \
	angstrom-gpe-task-base \
	angstrom-gpe-task-settings \
	xterm e-wm \
"

IMAGE_INSTALL = " task-base-extended \
	kernel-modules \
	gnuradio gnuradio-usrp \
	screen procps \
	${@base_contains("MACHINE_FEATURES", "screen", "${GUIPACKAGES}", "",d)} \
	python-core perl \
	uucp picocom \
	angstrom-zeroconf-audio avahi-utils \
	${ANGSTROM_EXTRA_INSTALL} \
"

inherit image

