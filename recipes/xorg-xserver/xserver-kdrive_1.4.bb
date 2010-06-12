require xserver-kdrive-common.inc

DEPENDS += "hal libxkbfile libxcalibrate pixman"
RDEPENDS_${PN} += "hal"

PE = "1"
PR = "${INC_PR}.1"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
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
	file://linux-keyboard-mediumraw.patch \
	file://xcalibrate-new-input-world-order.patch \
	file://tslib-default-device.patch \
	file://fbdev-evdev.patch \
	file://keyboard-resume-workaround.patch \
	file://xorg-avr32-support.diff \
	file://pkgconfig_fix.patch \
        "

S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"

EXTRA_OECONF += "--enable-builtin-fonts"

SRC_URI[md5sum] = "a06d9fe4f9f1d459ae02657f9ce64220"
SRC_URI[sha256sum] = "51b142df328d427143705371f139a08ff3bcd6efe0eab91f4178ca4017c0ebc2"
