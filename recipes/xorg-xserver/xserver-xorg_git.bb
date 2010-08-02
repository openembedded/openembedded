require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto xorg-minimal-fonts font-util-native"
PV = "1.8.99.905"
PR = "${INC_PR}.4"
PR_append = "+gitr${SRCPV}"
PE = "2"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"

SRCREV = "7e0575baf14ec4a89492fd2780f9ab5b9244afbd"
SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git;branch=master \
           file://dolt-fix-1.7.0.patch \
           file://randr-support-1.7.0.patch \
	   file://hack-fbdev-ignore-return-mode.patch \
           "

SRC_URI_append_angstrom = " file://hack-assume-pixman-supports-overlapped-blt.patch"
SRC_URI_append_shr = " file://hack-assume-pixman-supports-overlapped-blt.patch"

S = "${WORKDIR}/git"

do_install_prepend() {
        mkdir -p ${D}/${libdir}/X11/fonts
}

# The NVidia driver requires Xinerama support in the X server. Ion uses it.
PACKAGE_ARCH_ion = "${MACHINE_ARCH}"
XINERAMA = "${@['--disable-xinerama','--enable-xinerama'][bb.data.getVar('MACHINE',d) in ['ion']]}"

EXTRA_OECONF += " ${CONFIG_MANAGER_OPTION} ${XINERAMA} --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev --disable-dmx"

export LDFLAGS += " -ldl "
