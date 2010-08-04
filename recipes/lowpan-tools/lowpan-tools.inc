DESCRIPTION = "LoWPAN utilities (IEEE802.15.4)"
LICENSE = "GPLv2"
DEPENDS = "libnl bison-native flex-native python-native"
INC_PR = "r11"

SRC_URI = "http://prdownloads.sourceforge.net/linux-zigbee/linux-zigbee-sources/${PV}/lowpan-tools-${PV}.tar.gz"

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

inherit autotools python-dir
