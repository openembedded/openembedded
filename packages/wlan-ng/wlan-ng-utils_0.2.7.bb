require wlan-ng-utils.inc

SRC_URI += "file://scripts-makefile-hostcc.patch;patch=1 \
	file://pcmciasrc.patch;patch=1 \
	file://hostldflags.patch;patch=1"

PR = "r1"
