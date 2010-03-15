require xorg-driver-input.inc

PR = "r12"

DESCRIPTION = "X.Org X server -- evtouch input driver"

SRC_URI = "http://www.conan.de/touchscreen/xf86-input-evtouch-${PV}.tar.bz2 \
           file://fdi/*.fdi \
           file://udev-ett-tc5uh.patch;patch=1 \
           file://02_calibration_1.6.patch;patch=1 \
           file://03_server-1.6-ftbfs.diff;patch=1 \
           file://04_server-1.7-ftbfs.diff;patch=1 \
"

EXTRA_OECONF = "--enable-evcalibrate \
                --enable-udevinstall \
"

do_install_append() {
	install -d ${D}${datadir}/hal/fdi/policy/20thirdparty
	cp ${WORKDIR}/fdi/*.fdi ${D}${datadir}/hal/fdi/policy/20thirdparty
}

FILES_${PN} += "${datadir}/hal"
