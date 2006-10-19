PV = "1.1.0+git${SRCDATE}"
DEFAULT_PREFERENCE = "-2"

PR = "r7"

LICENSE = "MIT"
DEPENDS = "tslib virtual/libsdl libxkbfile xproto libxdmcp xextproto xtrans libxau virtual/libx11 libxext libxrandr fixesproto damageproto libxfont resourceproto compositeproto libxcalibrate recordproto videoproto scrnsaverproto"

PROVIDES = "virtual/xserver"
RPROVIDES = "virtual/xserver"
PACKAGES =+ "xserver-kdrive-fbdev xserver-kdrive-sdl xserver-kdrive-fake xserver-kdrive-xephyr xserver-kdrive-epson xserver-kdrive-w100"
SECTION = "x11/base"
DESCRIPTION = "X server from freedesktop.org"
DESCRIPTION_xserver-kdrive-fbdev = "X server from freedesktop.org, supporting generic framebuffer devices"
DESCRIPTION_xserver-kdrive-fake = "Fake X server"
DESCRIPTION_xserver-kdrive-xephyr = "X server in an X window"
DESCRIPTION_xserver-kdrive-epson = "X server from freedesktop.org, supporting Epson S1D13806 devices"
DESCRIPTION_xserver-kdrive-sdl = "X server from freedesktop.org, SDL version"
DESCRIPTION_xserver-kdrive-w100 = "X server from freedesktop.org, supporting the ATI imageon w100 chipset"

FILES_${PN} += "${libdir}/xserver/SecurityPolicy"

FILES_xserver-kdrive-fbdev = "${bindir}/Xfbdev"
FILES_xserver-kdrive-fake = "${bindir}/Xfake"
FILES_xserver-kdrive-xephyr = "${bindir}/Xephyr"
FILES_xserver-kdrive-epson = "${bindir}/Xepson"
FILES_xserver-kdrive-sdl = "${bindir}/Xsdl"
FILES_xserver-kdrive-w100 = "${bindir}/Xw100"

RDEPENDS_xserver-kdrive-fbdev = "${PN}"
RDEPENDS_xserver-kdrive-fake = "${PN}"
RDEPENDS_xserver-kdrive-xephyr = "${PN}"
RDEPENDS_xserver-kdrive-epson = "${PN}"
RDEPENDS_xserver-kdrive-sdl = "${PN}"
RDEPENDS_xserver-kdrive-w100 = "${PN}"

SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git \
	file://kmode.patch;patch=1 \
	file://disable-apm.patch;patch=1 \
	file://no-serial-probing.patch;patch=1 \
	file://kdrive-evdev.patch;patch=1  \
	file://kdrive-use-evdev.patch;patch=1  \
	file://fbdev-not-fix.patch;patch=1  \
	file://enable-builtin-fonts.patch;patch=1 \
	file://optional-xkb.patch;patch=1 \
	file://enable-epson.patch;patch=1 \
	file://disable-xf86-dga-xorgcfg-git.patch;patch=1 \
	file://w100.patch;patch=1 \
	"

SRC_URI_append_mnci   = " file://onlyfb.patch;patch=1"
SRC_URI_append_poodle = " file://xserver-kdrive-poodle.patch;patch=1"
PACKAGE_ARCH_poodle = "poodle"

S = "${WORKDIR}/git"

inherit autotools pkgconfig 

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"

EXTRA_OECONF = "--enable-composite --enable-kdrive \       
                --disable-dga --disable-dri --disable-xinerama \
                --disable-xf86misc --disable-xf86vidmode \
                --disable-xorg --disable-xorgcfg \
                --disable-xkb --disable-xnest --disable-xvfb \
                --disable-xevie --disable-xprint --disable-xtrap \
                --disable-dmx ${W100_OECONF} \
                --with-default-font-path=built-ins \
                --enable-tslib --enable-xcalibrate \
                ac_cv_file__usr_share_X11_sgml_defs_ent=no"
