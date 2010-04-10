SECTION = "x11/wm"
DESCRIPTION = "FVWM Window Manager"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 libxext libxfixes libxpm xrandr xft libxml2 zlib libice libxau libxcb libxcursor libxdmcp libxrender libpng librsvg fontconfig libstroke"

SRC_URI="ftp://ftp.fvwm.org/pub/fvwm/version-2/${P}.tar.bz2 \
	file://oe-configure.ac.patch;patch=1 \
	file://upstream-configure.ac.patch;patch=1 \
	file://acinclude.m4.patch;patch=1 \
	"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-xinerama --disable-bidi --disable-perllib \
	--disable-gtk --without-gnome --without-imlib \
	--disable-freetypetest --disable-fontconfigtest --disable-xfttest \
	--disable-imlibtest --disable-sm \
	"

PACKAGES =+ "${PN}-perl"

FILES_${PN}-dbg += " \
	${libexecdir}/${PN}/${PV}/.debug \
	${bindir}/${PN}-bug \
"

FILES_${PN}-dev += "${bindir}/${PN}-config"

FILES_${PN}-perl = " \
	${bindir}/${PN}-convert-2.4 \
	${bindir}/${PN}-convert-2.6 \
	${bindir}/${PN}-menu* \
	${bindir}/${PN}-perllib \
	${libexecdir}/${PN}/${PV}/FvwmPerl \
	${libexecdir}/${PN}/${PV}/FvwmCommand.pm \
	${libexecdir}/${PN}/${PV}/FvwmConsoleC.pl \
	${libexecdir}/${PN}/${PV}/FvwmDebug \
	${libexecdir}/${PN}/${PV}/FvwmGtkDebug \
	${libexecdir}/${PN}/${PV}/FvwmTabs \
	${libexecdir}/${PN}/${PV}/FvwmWindowMenu \
	${datadir}/${PN}/FvwmScript-ComExample \
	${datadir}/${PN}/FvwmScript-Setup95 \
	${datadir}/${PN}/fvwm-script-setup95.pl \
	${datadir}/${PN}/fvwm-script-ComExample.pl \
"


SRC_URI[md5sum] = "a1c225fe6497bf86a59cac561abd9064"
SRC_URI[sha256sum] = "84aca15165f600c5c09095c94b3ad1f0bfe16ba25cf2097f76312a0fba89251d"
