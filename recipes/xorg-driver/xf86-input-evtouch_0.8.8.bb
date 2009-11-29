require xorg-driver-input.inc

PR = "r11"

DESCRIPTION = "X.Org X server -- evtouch input driver"

SRC_URI = "http://www.conan.de/touchscreen/xf86-input-evtouch-${PV}.tar.bz2 \
           file://xf86-input-evtouch_0.8.8-0ubuntu6.diff;patch=1 \
           file://20_fix_calibrate_submission_directions.patch;patch=1 \
           file://21_more_calibration_fixups.patch;patch=1 \
           file://fdi/*.fdi \
           file://udev-ett-tc5uh.patch;patch=1 \
"

EXTRA_OECONF = "--enable-evcalibrate \
                --enable-udevinstall \
"

do_install_append() {
	install -d ${D}${datadir}/hal/fdi/policy/20thirdparty
	cp ${WORKDIR}/fdi/*.fdi ${D}${datadir}/hal/fdi/policy/20thirdparty
}

FILES_${PN} += "${datadir}/hal"
