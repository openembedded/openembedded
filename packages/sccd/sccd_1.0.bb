SECTION = "utility"
DECSCRIPTION = "StorCenter Control Daemon - controls the leds, fans, softpower"
LICENSE = "BSD"

PR = "r2"

SRC_URI = "file://scc.h \
	   file://scc.c \
	   file://sccd.c \
	   file://scc-utils.c \
	   file://scc-disk.c \
	   file://init-sccd \
	   file://Makefile \
	   file://README "

inherit autotools update-rc.d

INITSCRIPT_PARAMS = "defaults 91 20"
INITSCRIPT_NAME = "sccd"

do_unpack() {
	mkdir -p ${S}
	cp ${FILESDIR}/* ${S}
}

do_configure() {
	:
}

