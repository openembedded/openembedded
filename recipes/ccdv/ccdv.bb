DESCRIPTION = "ccdv is a tool to reduce the deluge of make output to make \
finding actual problems easier."
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

SRC_URI[md5sum] = "b8c51a2e3cccb381428426c0fc543244"
SRC_URI[sha256sum] = "f1e44d628cc4cbac192bf33f492ad8d1e1988cae576924128df36f3638e9a485"
