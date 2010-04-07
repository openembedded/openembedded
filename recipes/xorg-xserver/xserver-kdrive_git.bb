DEFAULT_PREFERENCE = "-2"

require xserver-kdrive-common.inc
SRCREV = "9b28d998424c77fbc057dd3a022ccbb122793a52"
PV = "1.4+git${SRCDATE}"

DEPENDS += "libxkbfile libxcalibrate pixman"

PE = "1"
PR = "${INC_PR}.0"

FILESPATH = "${FILE_DIRNAME}/xserver-kdrive-git:${FILE_DIRNAME}/xserver-kdrive"
SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch;patch=1 \
	file://fix_default_mode.patch;patch=1 \
	file://enable-xcalibrate.patch;patch=1 \
	file://hide-cursor-and-ppm-root.patch;patch=1 \
	file://xcalibrate_coords.patch;patch=1 \
	file://w100.patch;patch=1 \
	file://w100-autofoo.patch;patch=1 \
	file://w100-fix-offscreen-bmp.patch;patch=1 \
	file://w100-new-input-world-order.patch;patch=1 \
	file://w100-post-1.4-buildfix.patch;patch=1 \
	file://xcalibrate-new-input-world-order.patch;patch=1 \
	file://tslib-default-device.patch;patch=1 \
	file://fbdev-evdev.patch;patch=1 \
	file://xephyr-post-1.4-buildfix.patch;patch=1 \
	"

S = "${WORKDIR}/git"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"

EXTRA_OECONF += "--enable-builtin-fonts"
