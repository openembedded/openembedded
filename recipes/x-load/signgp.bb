LICENSE = "NewBSD"
DESCRIPTION = "Tool to sign omap3 x-loader images"

PR = "r4"

SRC_URI = "file://signGP.c"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/signGP.c -o signGP
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 signGP ${D}${bindir}
}

NATIVE_INSTALL_WORKS = "1"

BBCLASSEXTEND = "native sdk"
