require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto xorg-minimal-fonts font-util-native"
PV = "1.7.999"
PR = "${INC_PR}.0"
PR_append = "+gitr${SRCREV}"
PE = "2"

DEFAULT_PREFERENCE = "-1"

SRCREV = "67b814d9b2baea6beccfb1625a1e3f0b2ba7218b"
SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git;branch=master \
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

EXTRA_OECONF += " ${CONFIG_MANAGER_OPTION} ${XINERAMA} --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev --disable-dmx"

export LDFLAGS += " -ldl "
