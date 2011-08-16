DESCRIPTION = "SHR default module for the Phone UI daemon"
SECTION = "e/apps"
DEPENDS += " libphone-ui evas ecore edje edje-native elementary"
SRCREV = "88ea379ccac6d8a59ce798293a9238b92cac1467"
PE = "1"
PV = "0.0.1+gitr${SRCPV}"
PR = "r4"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.shr-project.org/repo/libphone-ui-shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"


do_configure_prepend() {
        autopoint --force
}

FILES_${PN} += "${libdir}/phoneui/modules/shr.so"
FILES_${PN}-dev += "${libdir}/phoneui/modules/*.la"
FILES_${PN}-dbg += "${libdir}/phoneui/modules/.debug"
FILES_${PN}-static += "${libdir}/phoneui/modules/*.a"
