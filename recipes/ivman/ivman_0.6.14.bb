DESCRIPTION = "Daemon to mount/unmount devices, based on info from HAL"
HOMEPAGE = "http://ivman.sf.net"
LICENSE = "GPLv2"
PR = "r1"

DEPENDS = "hal libxml2"
RDEPENDS = "hal pmount-hal"

SRC_URI = "${SOURCEFORGE_MIRROR}/ivman/${P}.tar.bz2 \
           file://ivman-0.6-hotpluggable.patch;patch=1 \
           file://ivman-launch.patch;patch=1 "

inherit autotools

# Add user ivman into group plugdev
pkg_postinst_${PN} () {
        # can't do this offline
        if [ "x$D" != "x" ]; then
                exit 1
        fi

        grep "^ivman:" /etc/passwd > /dev/null || \
             adduser --disabled-password --system --home /dev/null \
                     --no-create-home --ingroup plugdev -s /bin/false \
                     -g "IVMAN" ivman
        /etc/init.d/populate-volatile.sh update
}

pkg_postrm_${PN} () {
        deluser ivman || true
}

SRC_URI[md5sum] = "ebef12559268e2c5ea932cbb5aaa789e"
SRC_URI[sha256sum] = "62a6f9cb90999694e48528e16f427433c13a99424b5dca4cb38cda99e13d10e8"
