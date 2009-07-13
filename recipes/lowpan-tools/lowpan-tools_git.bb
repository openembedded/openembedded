DESCRIPTION = "LoWPAN utilities (IEEE802.15.4)"
LICENSE = "GPL"
SRCREV = "b30f459c9ef500b73043d105597f382ec4f53f1b"
SRC_URI = "git://linux-zigbee.git.sourceforge.net/gitroot/linux-zigbee;protocol=git"
DEPENDS = "libnl bison-native flex-native"
PR = "r8"

S = "${WORKDIR}/git"
PACKAGES += "${PN}-tests-dbg"
PACKAGES += "${PN}-tests"
FILES_${PN} = "${sbindir}/iz ${sbindir}/izconfig \
               ${bindir}/izchat ${bindir}/izlisten ${sbindir}/izcoordinator \
               ${sbindir}/izattach ${libdir}/ip/link_wpan.so"
FILES_${PN}-dbg += "${libdir}/ip/.debug/link_wpan.so"
FILES_${PN}-tests = "${libexecdir}/lowpan-tools ${libdir}/python*/site-packages"
FILES_${PN}-tests-dbg = "${libexecdir}/lowpan-tools/.debug"

EXTRA_OECONF = "--disable-manpages"

inherit autotools_stage
