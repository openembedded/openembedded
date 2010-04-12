DESCRIPTION = "Squeak VM"
LICENSE = "Squeak License"
HOMEPAGE = "http://www.squeakvm.org"
DEPENDS = "virtual/libx11 libffi"

EXTRA_OECONF += " --with-x --without-npsqueak --with-ffi=any-libffi --docdir=${docdir}/squeak"


SRC_URI = "http://www.squeakvm.org/unix/release/Squeak-3.10-1.src.tar.gz \
           file://configure-fixes.patch;patch=1"
S = "${WORKDIR}/Squeak-3.10-1/platforms/unix/config"

inherit autotools

do_patch_prepend() {
	import bb
	bb.data.setVar('S', '${WORKDIR}/Squeak-3.10-1', d)
}

do_configure() {
    mkdir -p ../bld
    cd ../bld
    oe_runconf
}

do_compile_prepend() {
    cd ../bld
}

do_install_prepend() {
    cd ../bld
}

do_install_append() {
    # Help to install the binary into the right place
    install -m 0755 ${S}/../bld/.libs/squeak ${D}${libdir}/squeak/3.10-1/
}

PACKAGES += "\
    ${PN}-plugin-midi             ${PN}-plugin-midi-dbg\
    ${PN}-plugin-tty              ${PN}-plugin-tty-dbg\
    ${PN}-plugin-sound-alsa       ${PN}-plugin-sound-alsa-dbg\
    ${PN}-plugin-sound-oss        ${PN}-plugin-sound-oss-dbg\
    ${PN}-plugin-sound-null       ${PN}-plugin-sound-null-dbg\
    ${PN}-plugin-xdisplaycontrol  ${PN}-plugin-xdisplaycontrol-dbg\
    ${PN}-plugin-b3daccelerator   ${PN}-plugin-b3daccelerator-dbg\
    ${PN}-plugin-display-x11      ${PN}-plugin-display-x11-dbg\
    ${PN}-plugin-display-null     ${PN}-plugin-display-null-dbg\
    ${PN}-plugin-display-fb       ${PN}-plugin-display-fb-dbg\
    ${PN}-plugin-v4l              ${PN}-plugin-v4l-dbg\
    ${PN}-plugin-squeak3d         ${PN}-plugin-squeak3d-dbg\
    ${PN}-plugin-unix-process    ${PN}-plugin-unix-process-dbg\
"

FILES_${PN} += " ${libdir}/squeak/3.10-1/squeak"
FILES_${PN}-dbg += " ${libdir}/squeak/3.10-1/.debug/squeak "

# plugins
FILES_${PN}-plugin-midi = "${libdir}/squeak/3.10-1/MIDIPlugin.so"
FILES_${PN}-plugin-tty = "${libdir}/squeak/3.10-1/PseudoTTYPlugin.so"
FILES_${PN}-plugin-sound-alsa = "${libdir}/squeak/3.10-1/vm-sound-ALSA.so"
FILES_${PN}-plugin-sound-null = "${libdir}/squeak/3.10-1/vm-sound-null.so"
FILES_${PN}-plugin-sound-oss = "${libdir}/squeak/3.10-1/vm-sound-OSS.so"
FILES_${PN}-plugin-xdisplaycontrol = "${libdir}/squeak/3.10-1/XDisplayControlPlugin.so"
FILES_${PN}-plugin-b3daccelerator = "${libdir}/squeak/3.10-1/B3DAcceleratorPlugin.so"
FILES_${PN}-plugin-display-x11 = "${libdir}/squeak/3.10-1/vm-display-X11.so"
FILES_${PN}-plugin-display-null = "${libdir}/squeak/3.10-1/vm-display-null.so"
FILES_${PN}-plugin-display-fb = "${libdir}/squeak/3.10-1/vm-display-fbdev.so"
FILES_${PN}-plugin-v4l = "${libdir}/squeak/3.10-1/VideoForLinuxPlugin.so"
FILES_${PN}-plugin-squeak3d = "${libdir}/squeak/3.10-1/Squeak3D.so"
FILES_${PN}-plugin-unix-process = "${libdir}/squeak/3.10-1/UnixOSProcessPlugin.so"

# debug package
FILES_${PN}-plugin-midi-dbg = "${libdir}/squeak/3.10-1/.debug/MIDIPlugin.so"
FILES_${PN}-plugin-tty-dbg = "${libdir}/squeak/3.10-1/.debug/PseudoTTYPlugin.so"
FILES_${PN}-plugin-sound-alsa-dbg = "${libdir}/squeak/3.10-1/.debug/vm-sound-ALSA.so"
FILES_${PN}-plugin-sound-null-dbg = "${libdir}/squeak/3.10-1/.debug/vm-sound-null.so"
FILES_${PN}-plugin-sound-oss-dbg = "${libdir}/squeak/3.10-1/.debug/vm-sound-OSS.so"
FILES_${PN}-plugin-xdisplaycontrol-dbg = "${libdir}/squeak/3.10-1/.debug/XDisplayControlPlugin.so"
FILES_${PN}-plugin-b3daccelerator-dbg = "${libdir}/squeak/3.10-1/.debug/B3DAcceleratorPlugin.so"
FILES_${PN}-plugin-display-x11-dbg = "${libdir}/squeak/3.10-1/.debug/vm-display-X11.so"
FILES_${PN}-plugin-display-null-dbg = "${libdir}/squeak/3.10-1/.debug/vm-display-null.so"
FILES_${PN}-plugin-display-fb-dbg = "${libdir}/squeak/3.10-1/.debug/vm-display-fbdev.so"
FILES_${PN}-plugin-v4l-dbg = "${libdir}/squeak/3.10-1/.debug/VideoForLinuxPlugin.so"
FILES_${PN}-plugin-squeak3d-dbg = "${libdir}/squeak/3.10-1/.debug/Squeak3D.so"
FILES_${PN}-plugin-unix-process-dbg = "${libdir}/squeak/3.10-1/.debug/UnixOSProcessPlugin.so"

SRC_URI[md5sum] = "7fbac029115831d18422f3079dbb0444"
SRC_URI[sha256sum] = "d5e9cab31f25f842f42bde153e04b93547b559e75da08f1b997a47f70d003133"
