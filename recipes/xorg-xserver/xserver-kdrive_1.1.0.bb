LICENSE = "MIT"
DEPENDS = "tslib xproto libxdmcp xextproto xtrans libxau virtual/libx11 libxext libxrandr fixesproto damageproto libxfont resourceproto compositeproto calibrateproto recordproto videoproto scrnsaverproto"

PROVIDES = "virtual/xserver"
PACKAGES =+ "xserver-kdrive-fbdev xserver-kdrive-fake xserver-kdrive-xephyr"
SECTION = "x11/base"
DESCRIPTION = "X server from freedesktop.org"
DESCRIPTION_xserver-kdrive-fbdev = "X server from freedesktop.org, supporting generic framebuffer devices"
DESCRIPTION_xserver-kdrive-fake = "Fake X server"
DESCRIPTION_xserver-kdrive-xephyr = "X server in an X window"

PE = "1"
PR = "r2"

FILES_${PN} = "${libdir}/xserver"
FILES_xserver-kdrive-fbdev = "${bindir}/Xfbdev"
FILES_xserver-kdrive-fake = "${bindir}/Xfake"
FILES_xserver-kdrive-xephyr = "${bindir}/Xephyr"

RDEPENDS_xserver-kdrive-fbdev = "${PN}"
RDEPENDS_xserver-kdrive-fake = "${PN}"
RDEPENDS_xserver-kdrive-xephyr = "${PN}"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-1.1.0.tar.bz2 \
	file://kmode.patch \
	file://disable-apm.patch \
	file://no-serial-probing.patch \
	file://kdrive-evdev.patch  \
	file://kdrive-use-evdev.patch  \
	file://fbdev-not-fix.patch  \
	file://enable-builtin-fonts.patch \
	file://optional-xkb.patch \
	file://disable-xf86-dga-xorgcfg.patch \
	file://enable-tslib.patch \
	file://xcalibrate.patch \
	file://xfbdev-fb-opt.patch \
	file://hide-cursor-and-ppm-root.patch \
	file://report-correct-randr10.patch"

SRC_URI_append_mnci   = " file://onlyfb.patch"
SRC_URI_append_poodle = " file://xserver-kdrive-poodle.patch"
SRC_URI_append_qemux86 = " file://xserver-kdrive-poodle.patch"
PACKAGE_ARCH_poodle = "poodle"

S = "${WORKDIR}/xorg-server-1.1.0"

inherit autotools pkgconfig 

EXTRA_OECONF = "--enable-composite --enable-kdrive \
		--disable-dga --disable-dri --disable-xinerama \
		--disable-xf86misc --disable-xf86vidmode \
		--disable-xorg --disable-xorgcfg \
		--disable-dmx \ 
		--disable-xkb --disable-xnest --disable-xvfb \
		--disable-xevie --disable-xprint --disable-xtrap \
		--with-default-font-path=built-ins \
		ac_cv_file__usr_share_sgml_X11_defs_ent=no"

do_configure_prepend() {
    sed -i -e 's/tslib-0.0/tslib-1.0/' ${S}/configure.ac
}

SRC_URI[md5sum] = "d070c58a598fb52c5cb86344725c4ad6"
SRC_URI[sha256sum] = "da1d5ce91098e1187579306275a9664ef6f1cea935fabcbd72f4c77af415a461"
