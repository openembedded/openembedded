DEPENDS = "virtual/libx11 libxi"

SRCREV  = "6af268f1b435f7bdd83335092ddc684054df2110"
SRC_URI = "git://github.com/tias/xinput_calibrator.git;protocol=git \
           file://0001-switch-to-autotools-based-build-system.patch;patch=1"

PR = "r1"
inherit autotools
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 xinput_calibrator_x11 ${D}${bindir}/xinput_calibrator
}
