DESCRIPTION = "Binaural tone generation tool."
HOMEPAGE = "http://uazu.net/sbagen/"
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

SRC_URI[md5sum] = "7d672f2f2a8e33e664b06777459471fe"
SRC_URI[sha256sum] = "3190534f4449f810d633b0a9848c7db1458b4c57249432a3932a468ecb06daea"
