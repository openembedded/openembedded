require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto xorg-minimal-fonts font-util-native"
PV = "1.7.999"
PR = "r2"
PR_append = "+gitr${SRCREV}"
PE = "2"

DEFAULT_PREFERENCE = "-1"

SRCREV = "84905007702da2c05a4f7446b3fc5ff52be49655"
SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git;branch=master \
           file://0001-glxdri2-flushInvalidate-was-renamed-to-invalidate-in.patch;patch=1 \
           file://dolt-fix-1.7.0.patch;patch=1 \
           file://randr-support-1.7.0.patch;patch=1 \
	   file://hack-fbdev-ignore-return-mode.patch;patch=1 \
           "

S = "${WORKDIR}/git"

do_install_prepend() {
        mkdir -p ${D}/${libdir}/X11/fonts
}

# The NVidia driver requires Xinerama support in the X server. Ion uses it.
XINERAMA = "${@['--disable-xinerama','--enable-xinerama'][bb.data.getVar('MACHINE',d) in ['ion']]}"

# hal, udev or disable both
DISTRO_XORG_CONFIG_MANAGER ?= "--enable-config-hal --disable-config-udev"
DISTRO_XORG_CONFIG_MANAGER_shr ?= "--disable-config-udev --disable-config-hal"

EXTRA_OECONF += " ${DISTRO_XORG_CONFIG_MANAGER} ${XINERAMA} --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev --disable-dmx"

export LDFLAGS += " -ldl "
