require xinput-calibrator.inc

SRC_URI = "git://github.com/tias/xinput_calibrator.git;protocol=git \
"

SRCREV = "d2ce98b3f638667dd64b6d718721379b2dc750a7"
S = "${WORKDIR}/git/"

do_install_append() {
        install -d ${D}${bindir}
        install -m 0755 scripts/xinput_calibrator_pointercal.sh ${D}${bindir}/xinput_calibrator_once.sh
        ln -s ${bindir}/xinput_calibrator_x11 ${D}${bindir}/xinput_calibrator
        install -d ${D}${datadir}/applications/
        install -m 0755 scripts/xinput_calibrator.desktop ${D}${datadir}/applications/xinput-calibrator.desktop
        install -m 0755 scripts/xinput_calibrator_get_hal_calibration.sh ${D}${bindir}/xinput_calibrator_get_hal_calibration.sh
}
