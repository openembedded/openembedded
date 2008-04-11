#Angstrom SDR image
# An image with tools for software defined radio and unicorn radio

# TODO: 
# http://poh9.blogspot.com/2008/02/for-my-own-future-reference-how-to.html
# X demo
# xorg.conf

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"

IMAGE_INSTALL = " task-base-extended \
	kernel-modules \
	task-proper-tools \
	gnuradio gnuradio-usrp \
	gnuplot \
	xf86-input-keyboard \
	xf86-input-evdev \
	xf86-input-mouse \
	xf86-video-dummy \
	xf86-video-fbdev \
	xf86-video-sisusb \
	xf86-video-vesa \
	python-core perl \
	uucp picocom \
	pulseaudio pulseaudio-module-zeroconf-publish avahi-utils \
"

inherit image

