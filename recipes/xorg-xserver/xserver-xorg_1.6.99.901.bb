require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto xorg-minimal-fonts"
PV = "1.6.99.901"
PE = "2"
PR = "r1.75"

SRC_URI += "file://sysroot_fix.patch;patch=1 \
            file://dolt-fix.patch;patch=1 \
            file://xserver-git-master-4d6b20c25af5f590f19530b6c007e3648a8037c3.patch;patch=1 \
           "
do_install_prepend() {
        mkdir -p ${D}/${libdir}/X11/fonts
}

EXTRA_OECONF += "--disable-xephyr --disable-config-hal --disable-xinerama --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev --disable-dmx"
EXTRA_OECONF += " --disable-glx-tls --enable-dri2 --disable-unit-tests "

export LDFLAGS += " -ldl "
