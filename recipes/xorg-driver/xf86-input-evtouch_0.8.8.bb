require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- evtouch input driver"
PR = "${INC_PR}.0"

SRC_URI = "http://www.conan.de/touchscreen/xf86-input-evtouch-${PV}.tar.bz2;name=archive \
           file://fdi/*.fdi \
           file://udev-ett-tc5uh.patch \
           file://02_calibration_1.6.patch \
           file://03_server-1.6-ftbfs.diff \
           file://04_server-1.7-ftbfs.diff \
"
SRC_URI[archive.md5sum] = "4d8e092356d8353002f60a4907046c13"
SRC_URI[archive.sha256sum] = "eafc4a09729a4b2b6120430c71e1954c5cac299ad6adf2f9a40aee8a7b51e476"

EXTRA_OECONF = "--enable-evcalibrate \
                --enable-udevinstall \
"

do_install_append() {
        install -d ${D}${datadir}/hal/fdi/policy/20thirdparty
        cp ${WORKDIR}/fdi/*.fdi ${D}${datadir}/hal/fdi/policy/20thirdparty
}

FILES_${PN} += "${datadir}/hal"
