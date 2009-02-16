DESCRIPTION = "LoWPAN utilities (IEEE802.15.4)"
LICENSE = "GPL"
SRCREV = "master"
SRC_URI = "git://github.com/lumag/lowpan-utils.git;protocol=git"
DEPENDS = "libnl bison-native flex-native"
PR = "r4"

S = "${WORKDIR}/git"
PACKAGES += "${PN}-tests-dbg"
PACKAGES += "${PN}-tests"
FILES_${PN} = "${sbindir}/iz ${sbindir}/izconfig \
               ${bindir}/izchat ${bindir}/izlisten ${sbindir}/izcoordinator \
               ${sbindir}/izattach"
FILES_${PN}-tests = "${libexecdir}/zigbee ${libdir}/python*/site-packages"
FILES_${PN}-tests-dbg = "${libexecdir}/zigbee/.debug"

inherit autotools

do_stage() {
     autotools_stage_all
}
