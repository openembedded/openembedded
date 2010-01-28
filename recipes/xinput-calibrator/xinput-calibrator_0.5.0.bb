DEPENDS = "virtual/libx11 libxi"

SRCREV  = "1c715824334c5d33085dba02f195c9720c2883b5"
SRC_URI = "git://github.com/tias/xinput_calibrator.git;protocol=git \
           file://xinput-calibrator.desktop \
"

PR = "r3"
inherit autotools
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 src/xinput_calibrator_x11 ${D}${bindir}/xinput_calibrator
	install -d ${D}${datadir}/applications/	
	install -m 0755 ${WORKDIR}/xinput-calibrator.desktop ${D}${datadir}/applications/xinput-calibrator.desktop	
}
