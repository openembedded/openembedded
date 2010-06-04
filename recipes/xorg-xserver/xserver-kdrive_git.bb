DEFAULT_PREFERENCE = "-2"

require xserver-kdrive-common.inc
SRCREV = "43285b4f72a0eb47aa0c33e4e41cd10434969991"
PV = "1.4.1+gitr${SRCREV}"

DEPENDS += "libxkbfile libxcalibrate pixman"

PE = "1"
PR = "${INC_PR}.0"

FILESPATHPKG =. "xserver-kdrive-git:xserver-kdrive:"
SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch \
	file://fix_default_mode.patch \
	file://enable-xcalibrate.patch \
	file://hide-cursor-and-ppm-root.patch \
	file://xcalibrate_coords.patch \
	file://w100.patch \
	file://w100-autofoo.patch \
	file://w100-fix-offscreen-bmp.patch \
	file://w100-new-input-world-order.patch \
	file://w100-post-1.4-buildfix.patch \
	file://xcalibrate-new-input-world-order.patch \
	file://tslib-default-device.patch \
	file://fbdev-evdev.patch \
	file://xephyr-post-1.4-buildfix.patch \
	"

S = "${WORKDIR}/git"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"

EXTRA_OECONF += "--enable-builtin-fonts"
