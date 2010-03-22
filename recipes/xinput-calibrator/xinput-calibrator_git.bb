require xinput-calibrator.inc

PV = "0.6.0+gitr${SRCREV}"

SRC_URI = "git://github.com/tias/xinput_calibrator.git;protocol=git;branch=misclick"

SRCREV = "496d4401731c6e5ed550e446cc2fc4b12d999ad8"
S = "${WORKDIR}/git/"

do_install_append() {
        install -d ${D}${bindir}
        install -m 0755 scripts/xinput_calibrator_pointercal.sh ${D}${bindir}/xinput_calibrator_once.sh
        ln -s ${bindir}/xinput_calibrator_x11 ${D}${bindir}/xinput_calibrator
        install -d ${D}${datadir}/applications/
        install -m 0755 scripts/xinput_calibrator.desktop ${D}${datadir}/applications/xinput-calibrator.desktop
}

# remove this after misclick branch is well-tested and merged to master
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"
