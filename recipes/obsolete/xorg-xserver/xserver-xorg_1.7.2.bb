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

SRC_URI[archive.md5sum] = "5c087e0f555203065fd90d02ef5f736e"
SRC_URI[archive.sha256sum] = "f4fb49209a6f3cb1c5b039b1f43870774e2eac1540b4d3235a2f13bc441da159"
