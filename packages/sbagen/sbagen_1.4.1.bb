DESCRIPTION = "Binaural tone generation tool."
HOMEPAGE = "http://uazu.net/sbagen/"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "tremor"

SRC_URI = "http://uazu.net/sbagen/sbagen-${PV}.tgz"
S = "${WORKDIR}/sbagen-${PV}"

LIBS = "-lm -lpthread -lvorbisidec"
DEFS = "-DT_LINUX -DOGG_DECODE"
# LIBS = "-lm -lpthread -lmad"
# DEFS = "-DT_LINUX -DMP3_DECODE"

do_compile () {
	${CC} ${CFLAGS} ${DEFS} sbagen.c ${LDFLAGS} -o sbagen ${LIBS}
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 sbagen ${D}${bindir}/
}
