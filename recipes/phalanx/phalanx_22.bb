DESCRIPTION = "Phalanx is a chess playing engine."
SECTION = "opie/libs"
PRIORITY = "optional"
PR = "r4"
LICENSE = "GPL"
SRC_URI = "http://ftp.debian.org/debian/pool/main/p/phalanx/phalanx_22.orig.tar.gz \
           file://gcc3.patch;patch=1 \
           file://capabilities \
           file://description"
S = "${WORKDIR}/phalanx-22.orig"

do_compile() {
	oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" STRIP=echo LD="${CC}"
}

do_install() {
	install -d ${D}${palmtopdir}/chess/engines/Phalanx
        install -D -m 755 phalanx ${D}${palmtopdir}/chess/engines/Phalanx/phalanx
        install -D -m 755 pbook.phalanx ${D}${palmtopdir}/chess/engines/Phalanx/pbook.phalanx
        >${D}${palmtopdir}/chess/engines/Phalanx/sbook.phalanx
        >${D}${palmtopdir}/chess/engines/Phalanx/learn.phalanx
        install -D -m 755 ${WORKDIR}/capabilities ${D}${palmtopdir}/chess/engines/Phalanx/capabilities
        install -D -m 755 ${WORKDIR}/description ${D}${palmtopdir}/chess/engines/Phalanx/description
}

FILES_${PN} = "${palmtopdir}/chess"
FILES_${PN}-dbg += "${palmtopdir}/chess/engines/Phalanx/.debug"
