#Angstrom SDR image
# An image with tools for software defined radio and unicorn radio

# TODO: 
# http://poh9.blogspot.com/2008/02/for-my-own-future-reference-how-to.html
# X demo
# xorg.conf

PR = "r2"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

# Also generate tar.bz2 images for use on e.g. SD or nfsroot
IMAGE_FSTYPES += "tar.bz2"

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"

# Install "big" X if the target has a screen
GUIPACKAGES = " \
        xf86-input-evdev \
        xf86-input-mouse \
        xf86-video-dummy \
        xf86-video-fbdev \
        ${@base_contains("COMBINED_FEATURES", "usbhost", "xf86-video-sisusb", "",d)} \
        xf86-video-vesa \
"

IMAGE_INSTALL = " task-base-extended \
	kernel-modules \
	gnuradio gnuradio-usrp \
	gnuplot \
	${@base_contains("MACHINE_FEATURES", "screen", "${GUIPACKAGES}", "",d)} \
	python-core perl \
	uucp picocom \
	angstrom-zeroconf-audio avahi-utils \
"

inherit image

