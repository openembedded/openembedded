DESCRIPTION = "Emulates Fn key by simulating multiple keypresses."
LICENSE = "GPLv2"
PR = "r1"

RDEPENDS_${PN} = "xdotool"

SRC_URI = "file://fnkey.c"

do_compile() {
	mv ${WORKDIR}/fnkey.c ${S}
	${CC} -o fnkey fnkey.c -I${STAGING_INCDIR} -L${STAGING_LIBDIR}
}

do_install() {
	install -d ${D}${bindir}
	install -m 755 fnkey ${D}${bindir}
}
