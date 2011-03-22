# Adobe provides two versions of flash player packages
#
# One "unversioned" download at :
#
#     ${ADOBE_MIRROR}/install_flash_player_9_linux.tar.gz
#
# And the other, versioned, which is encapsulated in RPM.
#
# We use the versioned one to make sure we can keep track of the
# version and thus do repeatable builds at the cost of future download
# failures when adobe updates.
DESCRIPTION = "Adobe Flash 9 plugin for Mozilla/Firefox web browsers"
LICENSE = "AdobeFlash"
DEPENDS = "rpm2cpio-native"
PR = "r1"

# it lacks GNU_HASH but we can't fix it, so ignore it
INSANE_SKIP_${PN} = "1"

SRC_URI = "${ADOBE_MIRROR}/flash-plugin-${PV}-release.i386.rpm"

SRC_URI[md5sum] = "4ef7c931c442aef19c920580de0e1c42"
SRC_URI[sha256sum] = "9899252732cc94b3bc0ae7e145c6c5e94255e123bd8d5298f9ec40cb10f63568"

do_configure() {
        rpm=${WORKDIR}/flash-plugin-${PV}-release.i386.rpm
        if [ -f "$rpm" ]; then
                rpm2cpio.pl $rpm | cpio -id
                find . -type f -exec mv -i {} "`pwd`" \;
        fi
}
do_install() {
        mkdir -p ${D}${libdir}/mozilla/plugins/
        install -m 0755 libflashplayer.so ${D}${libdir}/mozilla/plugins/
        # AFAIK this is not needed
        # install -m 0644 flashplayer.xpt ${D}${libdir}/mozilla/plugins/
}

FILES_${PN} = "${libdir}/* ${libdir}/X11/*"

COMPATIBLE_HOST = "i.86.*-linux"
