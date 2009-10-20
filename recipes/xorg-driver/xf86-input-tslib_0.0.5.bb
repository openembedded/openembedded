require xorg-driver-input.inc

DESCRIPTION = "X.Org X server -- tslib input driver"
RRECOMMENDS += "hal"
DEPENDS += "tslib"

PR = "r8"

SRC_URI = "http://www.pengutronix.de/software/xf86-input-tslib/download/xf86-input-tslib-${PV}.tar.bz2 \
	   file://011-ifdef-debug-output.patch;patch=1 \
	   file://012-deleteinput.patch;patch=1 \
	   file://015-add-randr-support.patch;patch=1 \
	   file://020-close-tsdevice-when-module-is-uninitialized.patch;patch=1 \
	   file://025-XI3.patch;patch=1 \
	   file://031-xserver-1.7.patch;patch=1 \
           file://use-hal-for-device.diff;patch=1 \
           file://dynamic-xy.patch;patch=1 \
           file://10-x11-input-tslib.fdi \
          "

do_configure_prepend() {
	rm -rf ${S}/m4/ || true
}

do_install_append() {
	install -d ${D}/${datadir}/hal/fdi/policy/20thirdparty
	install -m 0644 ${WORKDIR}/10-x11-input-tslib.fdi ${D}/${datadir}/hal/fdi/policy/20thirdparty
}

FILES_${PN} += "${datadir}/hal"

