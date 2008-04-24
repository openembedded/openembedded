DESCRIPTION = "Mamona's sound configuration for Nokia N770"
HOMEPAGE = "http://dev.openbossa.org/trac/mamona/"
#SECTION = "console/utils"
LICENSE = "GPL"
RDEPENDS = "dspgw-utils udev alsa-lib alsa-utils-alsactl"
PR = "r1"

PACKAGES = "${PN}"

SRC_URI = 	"file://dsp-n800.rules \
             file://asound.conf \
             "

# Skipping...
do_configure () {
}

# Skipping...
do_stage () {
}

# Skipping...
do_compile () {
}

do_install () {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0755 ${WORKDIR}/dsp-n800.rules ${D}${sysconfdir}/udev/rules.d/

    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/asound.conf ${D}${sysconfdir}/
}
