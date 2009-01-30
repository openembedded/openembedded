DESCRIPTION = "LoWPAN utilities (IEEE802.15.4)"
LICENSE = "GPL"
SRCREV = "master"
SRC_URI = "git://github.com/lumag/lowpan-utils.git;protocol=git"
DEPENDS = "libnl"
PR = "r1"

S = "${WORKDIR}/git"
PACKAGES += "${PN}-tests-dbg"
PACKAGES += "${PN}-tests"
FILES_${PN} = "${bindir}/iz ${sbindir}/izconfig \
               ${bindir}/izchat ${sbindir}/coordinator \
               ${sbindir}/izattach"
FILES_${PN}-tests = "${libexecdir}/zigbee"
FILES_${PN}-tests-dbg = "${libexecdir}/zigbee/.debug"

inherit autotools

do_install_append() {
     install -d ${D}${bindir}/.debug
     install -d ${D}${sbindir}/.debug
     mv ${D}${libexecdir}/zigbee/iz ${D}${bindir}/
     mv ${D}${libexecdir}/zigbee/izconfig ${D}${sbindir}/
     mv ${D}${libexecdir}/zigbee/izchat ${D}${bindir}/
     mv ${D}${libexecdir}/zigbee/coordinator ${D}${sbindir}/
     mv ${D}${libexecdir}/zigbee/serial ${D}${sbindir}/izattach
}

do_stage() {
     autotools_stage_all
}
