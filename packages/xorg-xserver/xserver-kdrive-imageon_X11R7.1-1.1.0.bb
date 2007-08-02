DESCRIPTION = "X server for Imageon Cards from freedesktop.org"
DESCRIPTION_xserver-kdrive-imageon = "X server from freedesktop.org, supporting the ATI imageon 100 chipset"

COMPATIBLE_MACHINE = "(c7x0|hx4700)"

SECTION = "x11/base"
LICENSE = "MIT"

DEPENDS = "tslib xproto libxdmcp xextproto xtrans libxau virtual/libx11 libxext libxrandr fixesproto damageproto libxfont resourceproto compositeproto libxcalibrate recordproto videoproto scrnsaverproto"

PROVIDES = "virtual/xserver"
RPROVIDES = "virtual/xserver"

PR = "r3"

FILESPATH = "${FILE_DIRNAME}/xserver-kdrive"

SRC_URI = "http://ftp.x.org/pub/X11R7.1/src/xserver/xorg-server-X11R7.1-1.1.0.tar.bz2 \
        file://kmode.patch;patch=1 \
        file://disable-apm.patch;patch=1 \
        file://no-serial-probing.patch;patch=1 \
        file://kdrive-evdev.patch;patch=1  \
        file://kdrive-use-evdev.patch;patch=1  \
        file://fbdev-not-fix.patch;patch=1  \
        file://enable-builtin-fonts.patch;patch=1 \
        file://optional-xkb.patch;patch=1 \
        file://disable-xf86-dga-xorgcfg.patch;patch=1 \
        file://enable-tslib.patch;patch=1 \
        file://xcalibrate.patch;patch=1 \
        file://kdrive-vidmemarea.patch;patch=1 \
        file://kdrive-imageon.patch;patch=1"

S = "${WORKDIR}/xorg-server-X11R7.1-1.1.0"

inherit autotools pkgconfig

ARM_INSTRUCTION_SET = "arm"
W100_OECONF_arm = "--enable-imageon"

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

FILES_${PN} = "${libdir}/xserver/SecurityPolicy \
               ${bindir}/Ximageon"
