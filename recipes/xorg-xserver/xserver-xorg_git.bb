require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto mesa xorg-minimal-fonts"
PV = "1.6.999+gitr${SRCPV}"
PR = "r3"
PE = "2"

DEFAULT_PREFERENCE = 1

SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git;branch=master \
           file://sysroot_fix.patch;patch=1 \
           file://dolt-fix.patch;patch=1 \
           file://fix-dri-build-without-xinerama.patch;patch=1 \
           file://x86emu.arm.undef.patch;patch=1 \
#           file://revert-xorg-master-1b30545c04a51bfa3ff95a26d64962907a62ff15.patch;patch=1 \
#           file://revert-xorg-master-e454f106dc65ecfacc154a1fa0810935022a8fee.patch;patch=1 \
          "

S = "${WORKDIR}/git"

do_install_prepend() {
        mkdir -p ${D}/${libdir}/X11/fonts
}

EXTRA_OECONF += "--disable-xephyr --disable-config-hal --disable-xinerama --disable-kdrive --disable-xephyr --disable-xsdl --disable-xfake --disable-xfbdev"
EXTRA_OECONF += " --disable-glx-tls --enable-dri2 --disable-unit-tests "

export LDFLAGS += " -ldl "
