require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto xorg-minimal-fonts"
PE = "2"
PR = "${INC_PR}.0"

SRC_URI += "file://sysroot_fix.patch;patch=1 \
            file://dolt-fix-1.7.0.patch;patch=1 \
            file://randr-support-1.7.0.patch;patch=1 \
            file://hack-fbdev-ignore-return-mode.patch;patch=1 \
           "

SRC_URI_append_angstrom = " file://hack-assume-pixman-supports-overlapped-blt.patch;patch=1"
SRC_URI_append_shr = " file://hack-assume-pixman-supports-overlapped-blt.patch;patch=1"

do_install_prepend() {
        mkdir -p ${D}/${libdir}/X11/fonts
}

# The NVidia driver requires Xinerama support in the X server. Ion uses it.
XINERAMA = "${@['--disable-xinerama','--enable-xinerama'][bb.data.getVar('MACHINE',d) in ['ion']]}"

EXTRA_OECONF += " --enable-config-hal ${XINERAMA} --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev --disable-dmx"
EXTRA_OECONF += " --disable-glx-tls --enable-dri2 --disable-unit-tests "

export LDFLAGS += " -ldl "
