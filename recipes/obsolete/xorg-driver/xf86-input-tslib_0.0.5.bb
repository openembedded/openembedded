require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- tslib input driver"
DEPENDS += "tslib"
RRECOMMENDS_${PN} += "hal tslib-calibrate"
PR = "${INC_PR}.0"

SRC_URI = "http://www.pengutronix.de/software/xf86-input-tslib/download/xf86-input-tslib-${PV}.tar.bz2;name=archive \
           file://use-hal-for-device.diff \
           file://01_fix-wrong-value-range-for-the-axises.diff \
           file://dynamic-xy.patch \
           file://xserver16.patch \
           file://10-x11-input-tslib.fdi"
SRC_URI[archive.md5sum] = "4231b517d216e9f80ba66f13a0f30afd"
SRC_URI[archive.sha256sum] = "d70c64f3f4fe931e12d5af7f91ff04cd0d16dd7459061c50b3149f9e35de8091"

do_configure_prepend() {
        rm -rf ${S}/m4/ || true
}
do_install_append() {
        install -d ${D}/${datadir}/hal/fdi/policy/20thirdparty
        install -m 0644 ${WORKDIR}/10-x11-input-tslib.fdi ${D}/${datadir}/hal/fdi/policy/20thirdparty
}

FILES_${PN} += "${datadir}/hal"
