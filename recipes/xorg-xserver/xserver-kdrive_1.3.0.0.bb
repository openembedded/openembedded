require xserver-kdrive-common.inc

DEPENDS += "libxkbfile libxcalibrate"

PE = "1"
PR = "${INC_PR}.0"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch;apply=yes \
	file://enable-builtin-fonts.patch;apply=yes \
	file://kdrive-evdev.patch;apply=yes  \
	file://kdrive-use-evdev.patch;apply=yes  \
	file://disable-xf86-dga-xorgcfg.patch;apply=yes \
        file://fix_default_mode.patch;apply=yes \
	file://enable-xcalibrate.patch;apply=yes \
	file://hide-cursor-and-ppm-root.patch;apply=yes \
	file://xcalibrate_coords.patch;apply=yes \
	file://w100.patch;apply=yes \
	file://w100-autofoo.patch;apply=yes \
	file://w100-fix-offscreen-bmp.patch;apply=yes \
        file://kdrive-1.3-18bpp.patch;apply=yes \
        file://linux-keyboard-mediumraw.patch;apply=yes \
        file://gumstix-kmode.patch;apply=yes \
        file://fix-picturestr-include-order.patch;apply=yes \
        file://autotools.patch;apply=yes \
	file://report-correct-randr12.patch;apply=yes \
"

SRC_URI_append_avr32 = " \
        file://xorg-avr32-support.diff;apply=yes \
"

SRC_URI_append_tosa = "file://tosa-fbdev.patch;apply=yes"
PACKAGE_ARCH_xserver-kdrive-fbdev_tosa = "${MACHINE_ARCH}"

S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"


SRC_URI[md5sum] = "a51a7d482e3c689394755bb17bda8526"
SRC_URI[sha256sum] = "93c656f142f37607c15372dd24c5de9eab82cd79c5d60449174a928d345c2975"
