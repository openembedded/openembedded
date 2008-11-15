require xorg-driver-input.inc

DESCRIPTION = "X.Org X server -- tslib input driver"
RRECOMMENDS += "hal"
DEPENDS += "tslib"

PR = "r6"

SRC_URI = "http://www.pengutronix.de/software/xf86-input-tslib/download/xf86-input-tslib-${PV}.tar.bz2 \
           file://use-hal-for-device.diff;patch=1 \
           file://01_fix-wrong-value-range-for-the-axises.diff;patch=1 \
           file://dynamic-xy.patch;patch=1 \
           file://10-x11-input-tslib.fdi"

do_configure_prepend() {
	rm -rf ${S}/m4/ || true
}

do_install_append() {
	install -d ${D}/${datadir}/hal/fdi/policy/20thirdparty
	install -m 0644 ${WORKDIR}/10-x11-input-tslib.fdi ${D}/${datadir}/hal/fdi/policy/20thirdparty
}

FILES_${PN} += "${datadir}/hal"

