require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto xorg-minimal-fonts"
PE = "2"
PR = "${INC_PR}.0"

SRC_URI += "file://sysroot_fix.patch;patch=1 \
            file://dolt-fix-1.7.0.patch;patch=1 \
            file://randr-support-1.7.0.patch;patch=1 \
           "
do_install_prepend() {
        mkdir -p ${D}/${libdir}/X11/fonts
}

EXTRA_OECONF += "--disable-xephyr --disable-config-hal --disable-xinerama --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev --disable-dmx"
EXTRA_OECONF += " --disable-glx-tls --enable-dri2 --disable-unit-tests "

export LDFLAGS += " -ldl "

SRC_URI[archive.md5sum] = "dda7842467cda6018fdc87e6002e4db1"
SRC_URI[archive.sha256sum] = "a58c0de29cbd2b7d1a1ac5ee70a94ad1ed2a085132803c0ca83f2dd8513b4c20"
