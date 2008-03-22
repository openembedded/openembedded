require wlan-ng-utils.inc

PR = "r3"

SRC_URI += "file://scripts-makefile-hostcc.patch;patch=1 \
	file://pcmciasrc.patch;patch=1 \
	file://hostldflags.patch;patch=1"
