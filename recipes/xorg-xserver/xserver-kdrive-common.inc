LICENSE = "MIT"
DEPENDS = "compositeproto damageproto fixesproto recordproto resourceproto scrnsaverproto xineramaproto videoproto xextproto xproto \
	libxau libxext libxdmcp libxfont libxrandr tslib virtual/libx11 xtrans xextproto-70-includes"
INC_PR = "r28"

PKGN ?= "xserver-kdrive"

PROVIDES = "virtual/xserver"
PACKAGES =+ "${PKGN}-fbdev \
             ${PKGN}-sdl \
             ${PKGN}-fake \
             ${PKGN}-xephyr \
             ${PKGN}-epson \
             ${PKGN}-ati \
             ${PKGN}-chips \
             ${PKGN}-i810 \
             ${PKGN}-mach64 \
             ${PKGN}-mga \
             ${PKGN}-neomagic \
             ${PKGN}-nvidia \
             ${PKGN}-pm2 \
             ${PKGN}-r128 \
             ${PKGN}-smi \
             ${PKGN}-vesa \
             ${PKGN}-via \
             ${PKGN}-w100 \
        "

SECTION = "x11/base"
DESCRIPTION = "X server from freedesktop.org"
DESCRIPTION_${PKGN}-fbdev = "X server from freedesktop.org, supporting generic framebuffer devices"
DESCRIPTION_${PKGN}-fake = "Fake X server"
DESCRIPTION_${PKGN}-xephyr = "X server in an X window"
DESCRIPTION_${PKGN}-epson = "X server from freedesktop.org, supporting Epson S1D13806 devices"
DESCRIPTION_${PKGN}-sdl = "X server from freedesktop.org, SDL version"
DESCRIPTION_${PKGN}-w100 = "X server from freedesktop.org, supporting the ATI imageon w100 chipset"
DESCRIPTION_${PKGN}-ati = "X server from freedesktop.org, supporting ATI devices"
DESCRIPTION_${PKGN}-chips = "X server from freedesktop.org, supporting Chips chipsets"
DESCRIPTION_${PKGN}-i810 = "X server from freedesktop.org, supporting Intel chipsets"
DESCRIPTION_${PKGN}-imageon = "X server from freedesktop.org, supporting the ATI imageon 100 chipset"
DESCRIPTION_${PKGN}-mach64 = "X server from freedesktop.org, supporting mach64 chipsets"
DESCRIPTION_${PKGN}-mga = "X server from freedesktop.org, supporting mga chipsets"
DESCRIPTION_${PKGN}-neomagic = "X server from freedesktop.org, supporting neomagic chipsets"
DESCRIPTION_${PKGN}-nvidia = "X server from freedesktop.org, supporting nvidia devices"
DESCRIPTION_${PKGN}-pm2 = "X server from freedesktop.org, supporting Permedia2 chipsets"
DESCRIPTION_${PKGN}-r128 = "X server from freedesktop.org, supporting rage128 chipsets"
DESCRIPTION_${PKGN}-smi = "X server from freedesktop.org, supporting Silicon Motion devices"
DESCRIPTION_${PKGN}-vesa = "X server from freedesktop.org, supporting any card with a VESA, VGA or even EGA BIOS. x86 hardware only"
DESCRIPTION_${PKGN}-via = "X server from freedesktop.org, supporting VIA chipsets"

PACKAGES =+ "xserver-security-policy"
FILES_xserver-security-policy += "${libdir}/xserver/SecurityPolicy"
RRECOMMENDS_${PN} += "xserver-security-policy"

FILES_${PKGN}-fbdev = "${bindir}/Xfbdev"
FILES_${PKGN}-fake = "${bindir}/Xfake"
FILES_${PKGN}-xephyr = "${bindir}/Xephyr"
FILES_${PKGN}-epson = "${bindir}/Xepson"
FILES_${PKGN}-sdl = "${bindir}/Xsdl"
FILES_${PKGN}-w100 = "${bindir}/Xw100"
FILES_${PKGN}-ati = "${bindir}/Xati"
FILES_${PKGN}-chips = "${bindir}/Xchips"
FILES_${PKGN}-i810 = "${bindir}/Xi810"
FILES_${PKGN}-imageon = "${bindir}/Ximageon"
FILES_${PKGN}-mach64 = "${bindir}/Xmach64"
FILES_${PKGN}-mga = "${bindir}/Xmga"
FILES_${PKGN}-neomagic = "${bindir}/Xneomagic"
FILES_${PKGN}-nvidia = "${bindir}/Xnvidia"
FILES_${PKGN}-pm2 = "${bindir}/Xpm2"
FILES_${PKGN}-r128 = "${bindir}/Xr128"
FILES_${PKGN}-smi = "${bindir}/Xsmi"
FILES_${PKGN}-vesa = "${bindir}/Xvesa"
FILES_${PKGN}-via = "${bindir}/Xvia"

SRC_URI ?= "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2;name=archive \
	${KDRIVE_COMMON_PATCHES}"
KDRIVE_COMMON_PATCHES = " \
	file://kmode.patch;patch=1 \
	file://kmode-800_480.patch;patch=1 \
	file://disable-apm.patch;patch=1 \
	file://no-serial-probing.patch;patch=1 \
	file://fbdev-not-fix.patch;patch=1  \
	file://optional-xkb.patch;patch=1 \
	file://enable-tslib.patch;patch=1 \
	file://kmode-palm.patch;patch=1 \
	"

SRC_URI_append_mnci   = " file://onlyfb.patch;patch=1"
SRC_URI_append_poodle = " file://xserver-kdrive-poodle.patch;patch=1"
SRC_URI_append_qemux86 = " file://xserver-kdrive-poodle.patch;patch=1"
PACKAGE_ARCH_poodle = "${MACHINE_ARCH}"
PACKAGE_ARCH_qemux86 = "${MACHINE_ARCH}"

inherit autotools pkgconfig

ARM_INSTRUCTION_SET = "arm"

CFLAGS_prepend = "-I${STAGING_INCDIR}/xextproto-70 "

EXTRA_OECONF = "--enable-composite --enable-kdrive \
                --disable-dga --disable-dri --disable-xinerama \
                --disable-xf86misc --disable-xf86vidmode \
                --disable-xorg --disable-xorgcfg \
                --disable-xkb --disable-xnest --disable-xvfb \
                --disable-xevie --disable-xprint --disable-xtrap \
                --disable-dmx ${W100_OECONF} \
                --with-default-font-path=built-ins \
                --enable-tslib --enable-xcalibrate \
                ac_cv_file__usr_share_sgml_X11_defs_ent=no"

do_configure_prepend() {
    sed -i -e 's/tslib-0.0/tslib-1.0/' ${S}/configure.ac
}
