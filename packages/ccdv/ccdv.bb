DESCRIPTION = "ccdv is a tool to reduce the deluge of make output to make \
finding actual problems easier."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPL"
SRC_URI = "http://openembedded.org/dl/ccdv.c"
S = "${WORKDIR}"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} ccdv.c -o ccdv
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ccdv ${D}${bindir}/
}
