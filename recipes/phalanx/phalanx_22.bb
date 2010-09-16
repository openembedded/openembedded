DESCRIPTION = "Phalanx is a chess playing engine."
SECTION = "opie/libs"
PRIORITY = "optional"
PR = "r5"
LICENSE = "GPL"
SRC_URI = "http://ftp.debian.org/debian/pool/main/p/phalanx/phalanx_22+d051004.orig.tar.gz \
           file://capabilities \
           file://description"
S = "${WORKDIR}/Phalanx-XXII/"

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
SRC_URI[md5sum] = "24657c063f5fda57e70130483bd45cd0"
SRC_URI[sha256sum] = "1ec5e8e5f71e199963796462086a6e9a0d8856b7fd4b83324a30a35c25677082"

