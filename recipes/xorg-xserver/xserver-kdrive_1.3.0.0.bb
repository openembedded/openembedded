require xserver-kdrive-common.inc

DEPENDS += "libxkbfile libxcalibrate"

PE = "1"
PR = "${INC_PR}.0"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch;patch=1 \
	file://enable-builtin-fonts.patch;patch=1 \
	file://kdrive-evdev.patch;patch=1  \
	file://kdrive-use-evdev.patch;patch=1  \
	file://disable-xf86-dga-xorgcfg.patch;patch=1 \
        file://fix_default_mode.patch;patch=1 \
	file://enable-xcalibrate.patch;patch=1 \
	file://hide-cursor-and-ppm-root.patch;patch=1 \
	file://xcalibrate_coords.patch;patch=1 \
	file://w100.patch;patch=1 \
	file://w100-autofoo.patch;patch=1 \
	file://w100-fix-offscreen-bmp.patch;patch=1 \
        file://kdrive-1.3-18bpp.patch;patch=1 \
        file://linux-keyboard-mediumraw.patch;patch=1 \
        file://gumstix-kmode.patch;patch=1 \
        file://fix-picturestr-include-order.patch;patch=1 \
        file://autotools.patch;patch=1 \
	file://report-correct-randr12.patch;patch=1 \
"

SRC_URI_append_avr32 = " \
        file://xorg-avr32-support.diff;patch=1 \
"

SRC_URI_append_tosa = "file://tosa-fbdev.patch;patch=1"
PACKAGE_ARCH_xserver-kdrive-fbdev_tosa = "${MACHINE_ARCH}"

S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"

