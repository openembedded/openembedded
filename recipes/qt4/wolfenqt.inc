
PR = "r1"
PE = "1"
PV = "0.0"
PR_append = "+gitr${SRCREV}"

inherit qt4${WOLFVARIANT}

SRCREV = "f43dfa2bfa1f72abd3500dfc94248b17c5f9ae05"
SRC_URI = "git://gitorious.org/qt-labs/wolfenqt.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 qt3d  ${D}${bindir}/wolfenqt-${WOLFVARIANT}
}



