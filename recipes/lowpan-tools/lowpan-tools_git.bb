DESCRIPTION = "LoWPAN utilities (IEEE802.15.4)"
LICENSE = "GPL"
SRCREV = "e9e80a2eefa7aadbbb15bef1519b373e2e907aa0"
#SRC_URI = "git://github.com/lumag/lowpan-utils.git;protocol=git"
SRC_URI = "git://linux-zigbee.git.sourceforge.net/gitroot/linux-zigbee;protocol=git"
DEPENDS = "libnl bison-native flex-native"
PR = "r6"

S = "${WORKDIR}/git"
PACKAGES += "${PN}-tests-dbg"
PACKAGES += "${PN}-tests"
FILES_${PN} = "${sbindir}/iz ${sbindir}/izconfig \
               ${bindir}/izchat ${bindir}/izlisten ${sbindir}/izcoordinator \
               ${sbindir}/izattach"
FILES_${PN}-tests = "${libexecdir}/lowpan-tools ${libdir}/python*/site-packages"
FILES_${PN}-tests-dbg = "${libexecdir}/lowpan-tools/.debug"

EXTRA_OECONF = "--disable-manpages"

inherit autotools_stage
