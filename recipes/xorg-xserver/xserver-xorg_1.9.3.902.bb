# Assign it here, since the hal->udev transition happens post 1.7 in angstrom
DISTRO_XORG_CONFIG_MANAGER_angstrom = "udev"

require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto xorg-minimal-fonts font-util-native"
PE = "2"
PR = "${INC_PR}.0"

SRC_URI += " \
            file://dolt-fix.patch \
            file://randr-support.patch \
            file://hack-fbdev-ignore-return-mode.patch \
            file://hack-assume-pixman-supports-overlapped-blt.patch \
           "
SRC_URI[archive.md5sum] = "9a9f3f1f843b23a3c343cec6fb179242"
SRC_URI[archive.sha256sum] = "8f6dbb113b9ca0314f9467c34647edda106fcb99db5ed9f8a5db04a9175abbe6"

do_install_prepend() {
        mkdir -p ${D}/${libdir}/X11/fonts
}

# The NVidia driver requires Xinerama support in the X server. Ion uses it.
PACKAGE_ARCH_ion = "${MACHINE_ARCH}"
XINERAMA = "${@['--disable-xinerama','--enable-xinerama'][bb.data.getVar('MACHINE',d) in ['ion']]}"

EXTRA_OECONF += " ${CONFIG_MANAGER_OPTION} ${XINERAMA} --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev --disable-dmx"
EXTRA_OECONF += " --enable-dri2 --disable-unit-tests --disable-docs --disable-devel-docs"

export LDFLAGS += " -ldl "
