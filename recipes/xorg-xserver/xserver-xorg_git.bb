require xorg-xserver-common.inc

DESCRIPTION = "the X.Org X server"
DEPENDS += "pixman libpciaccess openssl dri2proto glproto xorg-minimal-fonts font-util-native"
PV = "1.7.999"
PR = "${INC_PR}.0"
PR_append = "+gitr${SRCREV}"
PE = "2"

DEFAULT_PREFERENCE = "-1"

SRCREV = "780c95caf9888fa4548dfe4c1c78a7e7ce99a9ed"
SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git;branch=master \
# pending changes http://lists.x.org/archives/xorg-devel/2010-January/005127.html
           file://0001-Add-a-PreConfigureWindow-hook.patch;patch=1 \
           file://0002-dri2-No-need-to-blit-from-front-on-DRI2GetBuffers-if.patch;patch=1 \
           file://0003-glx-Enforce-a-1-1-correspondence-between-GLX-and-X11.patch;patch=1 \
           file://0004-glx-dri2-Notify-the-driver-when-its-buffers-become-i.patch;patch=1 \
           file://0005-dri2-Support-the-DRI2InvalidateBuffers-event.patch;patch=1 \
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
