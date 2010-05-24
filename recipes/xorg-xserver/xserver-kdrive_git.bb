DEFAULT_PREFERENCE = "-2"

require xserver-kdrive-common.inc
SRCREV = "43285b4f72a0eb47aa0c33e4e41cd10434969991"
PV = "1.4.1+gitr${SRCREV}"

DEPENDS += "libxkbfile libxcalibrate pixman"

PE = "1"
PR = "${INC_PR}.0"

FILESPATH = "${FILE_DIRNAME}/xserver-kdrive-git:${FILE_DIRNAME}/xserver-kdrive"
SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch;apply=yes \
	file://fix_default_mode.patch;apply=yes \
	file://enable-xcalibrate.patch;apply=yes \
	file://hide-cursor-and-ppm-root.patch;apply=yes \
	file://xcalibrate_coords.patch;apply=yes \
	file://w100.patch;apply=yes \
	file://w100-autofoo.patch;apply=yes \
	file://w100-fix-offscreen-bmp.patch;apply=yes \
	file://w100-new-input-world-order.patch;apply=yes \
	file://w100-post-1.4-buildfix.patch;apply=yes \
	file://xcalibrate-new-input-world-order.patch;apply=yes \
	file://tslib-default-device.patch;apply=yes \
	file://fbdev-evdev.patch;apply=yes \
	file://xephyr-post-1.4-buildfix.patch;apply=yes \
	"

S = "${WORKDIR}/git"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"

EXTRA_OECONF += "--enable-builtin-fonts"
