PR = "r5"

SRC_URI = "http://projects.linuxtogo.org/~jay7/kexecboot-${PV}.tar.gz \
	file://add-reboot-option.patch;patch=1 \
	file://scan_devices-top.patch;patch=1 \
	file://graphical-no-devices.patch;patch=1 \
	file://switch-cursor-off.patch;patch=1 \
	file://add-sleep.patch;patch=1 \
	file://silent-output-hack.patch;patch=1 \
	file://kexecboot-tosa.patch;patch=1 \
	file://fb-render-16bit.patch;patch=1"

S = "${WORKDIR}/kexecboot-${PV}"

require kexecboot.inc
