require wlan-ng-utils.inc

SRCDATE = "20060823"
PV = "0.2.4+svn${SRCDATE}"

SRC_URI = "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk \
	file://only-the-utils.patch;patch=1 \
	file://scripts-makefile-hostcc.patch;patch=1 \
	file://pcmciasrc.patch;patch=1 \
	file://hostldflags.patch;patch=1 \
	file://wlan-ng.modutils \
	file://wlan.agent \
	file://usbctl \
	file://resume \
	file://pre-up \
	file://post-down \
	file://config.in"
S = "${WORKDIR}/trunk"
