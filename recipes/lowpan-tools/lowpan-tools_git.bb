DESCRIPTION = "LoWPAN utilities (IEEE802.15.4)"
LICENSE = "GPL"
SRCREV = "fbeb38b276be720bb72e36e100fab8a23ec58dfe"
SRC_URI = "git://linux-zigbee.git.sourceforge.net/gitroot/linux-zigbee/linux-zigbee;protocol=git"
DEPENDS = "libnl bison-native flex-native python-native"
PR = "r10"

S = "${WORKDIR}/git"
PACKAGES += "${PN}-tests-dbg"
PACKAGES += "${PN}-tests"
FILES_${PN} = "${sbindir}/iz ${sbindir}/izconfig \
               ${bindir}/izchat ${bindir}/izlisten ${sbindir}/izcoordinator \
               ${sbindir}/izattach ${libdir}/ip/link_wpan.so"
FILES_${PN}-dbg += "${libdir}/ip/.debug/link_wpan.so"
FILES_${PN}-tests = "${libexecdir}/lowpan-tools ${PYTHON_SITEPACKAGES_DIR}"
FILES_${PN}-tests-dbg = "${libexecdir}/lowpan-tools/.debug"
RDEPENDS_${PN}-tests += "${PN} python-core"

EXTRA_OECONF = "--disable-manpages"

inherit autotools_stage python-dir
