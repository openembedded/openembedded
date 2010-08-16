require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto"
PE = "2"
PR = "${INC_PR}.2"

SRC_URI += "file://sysroot_fix.patch \
            file://dolt-fix.patch \
            file://randr-support.patch \
	    file://hack-fbdev-ignore-return-mode.patch \
           "

SRC_URI_append_angstrom = " file://hack-assume-pixman-supports-overlapped-blt.patch"
SRC_URI_append_shr = " file://hack-assume-pixman-supports-overlapped-blt.patch"

do_install_prepend() {
        mkdir -p ${D}/${libdir}/X11/fonts
}

# The NVidia driver requires Xinerama support in the X server. Ion uses it.
PACKAGE_ARCH_ion = "${MACHINE_ARCH}"
XINERAMA = "${@['--disable-xinerama','--enable-xinerama'][bb.data.getVar('MACHINE',d) in ['ion']]}"

EXTRA_OECONF += " ${CONFIG_MANAGER_OPTION} ${XINERAMA} --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev --disable-dmx"
EXTRA_OECONF += " --enable-dri2 --disable-unit-tests "

export LDFLAGS += " -ldl "

SRC_URI[archive.md5sum] = "75d27c3a1c12293f620a2d6518fcbdfa"
SRC_URI[archive.sha256sum] = "b8ec11b3f2c6f84c21e8cd9804672ba6e27fda3e913d58dd947205ea253e33f8"
