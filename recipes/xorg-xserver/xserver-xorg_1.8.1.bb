# Assign it here, since the hal->udev transition happens post 1.7 in angstrom
DISTRO_XORG_CONFIG_MANAGER_angstrom = "udev"

require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto xorg-minimal-fonts font-util-native"
PE = "2"
PR = "${INC_PR}.1"

# Needs newer mesa-dri, where is D_P = "-1"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"

SRC_URI += " \
            file://dolt-fix-1.7.0.patch;patch=1 \
            file://randr-support-1.7.0.patch;patch=1 \
	    file://hack-fbdev-ignore-return-mode.patch;patch=1 \
           "
SRC_URI[archive.md5sum] = "7c3b873692f4e93938261d774510e78d"
SRC_URI[archive.sha256sum] = "bddb974d8f21107ab8f79abf92cebb06ec13243f1ffd1ef56b48452c4994659d"

SRC_URI_append_angstrom = " file://hack-assume-pixman-supports-overlapped-blt.patch;patch=1"
SRC_URI_append_shr = " file://hack-assume-pixman-supports-overlapped-blt.patch;patch=1"

do_install_prepend() {
        mkdir -p ${D}/${libdir}/X11/fonts
}

# The NVidia driver requires Xinerama support in the X server. Ion uses it.
PACKAGE_ARCH_ion = "${MACHINE_ARCH}"
XINERAMA = "${@['--disable-xinerama','--enable-xinerama'][bb.data.getVar('MACHINE',d) in ['ion']]}"

EXTRA_OECONF += " ${CONFIG_MANAGER_OPTION} ${XINERAMA} --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev --disable-dmx"
EXTRA_OECONF += " --disable-glx-tls --enable-dri2 --disable-unit-tests "

export LDFLAGS += " -ldl "
