LICENSE = "MIT"
DEPENDS = "tslib xproto libxdmcp xextproto xtrans libxau virtual/libx11 libxext libxrandr fixesproto damageproto libxfont resourceproto compositeproto calibrateproto recordproto videoproto scrnsaverproto xpext xsp libxkbfile dbus"

PROVIDES = "virtual/xserver"
PACKAGES =+ "xserver-kdrive-xomap"
SECTION = "x11/base"
DESCRIPTION = "X server from freedesktop.org"
DESCRIPTION_xserver-kdrive-xomap = "X server for the OMAP in the Nokia 800"

PR = "r3"
PE = "1"

COMPATIBLE_MACHINE = "nokia(800|770)"

FILES_${PN} = "${libdir}/xserver /etc/dbus-1/* ${bindir}/Xomap"

SRC_URI = "http://repository.maemo.org/pool/maemo3.1/free/source/xorg-server_1.1.99.3-0osso31.tar.gz \
	file://kmode.patch \
	file://disable-apm.patch \
	file://no-serial-probing.patch \
	file://fbdev-not-fix.patch  \
	file://enable-builtin-fonts.patch \
	file://xcalibrate.patch \
	file://fixups.patch \
	file://button_only.patch \
	file://calibrateext.patch \
        file://fix-picturestr-include-order.patch \
	file://xcalibrate_coords.patch \
	file://report-correct-randr10.patch"
#	file://kdrive-evdev.patch  \
#	file://kdrive-use-evdev.patch  \
#	file://optional-xkb.patch \
#	file://disable-xf86-dga-xorgcfg.patch \
#	file://enable-tslib.patch \
#	file://xfbdev-fb-opt.patch"

S = "${WORKDIR}/xorg-server-1.1.99.3"

inherit autotools pkgconfig 

EXTRA_OECONF = "--enable-composite --enable-kdrive --enable-builtin-fonts \
		--disable-dga --disable-dri --disable-xinerama \
		--disable-xf86misc --disable-xf86vidmode \
		--disable-xorg --disable-xorgcfg \
		--disable-dmx --enable-xcalibrate \ 
		--disable-xkb --disable-xnest --disable-xvfb \
		--disable-xevie --disable-xprint --disable-xtrap \
		--with-default-font-path=built-ins \
		ac_cv_file__usr_share_sgml_X11_defs_ent=no \
		--enable-xomap"

do_configure_prepend() {
    sed -i -e 's/tslib-0.0/tslib-1.0/' ${S}/configure.ac
}

SRC_URI[md5sum] = "19a246ea30233ef3c5fe16248b771862"
SRC_URI[sha256sum] = "211f4d13d8cd726b10553534a4d0f0267b18d39dd30b2f5bc6dfcde9f6d6b8c9"
