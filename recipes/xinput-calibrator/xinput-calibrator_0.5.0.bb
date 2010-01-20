DEPENDS = "virtual/libx11 libxi"

SRCREV  = "6af268f1b435f7bdd83335092ddc684054df2110"
SRC_URI = "git://github.com/tias/xinput_calibrator.git;protocol=git \
           file://use-proper-compiler.patch;patch=1"

S = "${WORKDIR}/git/"
EXTRA_OEMAKE = "x11"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 xinput_calibrator ${D}${bindir}
}
