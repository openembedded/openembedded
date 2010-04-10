DESCRIPTION = "The Berkeley MPEG Encoder."
HOMEPAGE = "http://bmrc.berkeley.edu/frame/research/mpeg/mpeg_encode.html"
SECTION = "multimedia"
PR = "r2"

SRC_URI = "http://bmrc.berkeley.edu/ftp/pub/multimedia/mpeg/encode/mpeg_encode-${PV}-src.tar.gz \
           file://fixup.patch;patch=1"

S = "${WORKDIR}/mpeg_encode"

CFLAGS_append += " -I${S}/headers"

do_install() {
        install -D -m 0755 ${S}/mpeg_encode ${D}${bindir}/mpeg_encode
        install -D -m 0644 ${S}/mpeg_encode.1 ${D}${mandir}/man1/mpeg_encode.1
}

SRC_URI[md5sum] = "ff125fb82118efc7c852f0d26d5552c6"
SRC_URI[sha256sum] = "dd8db42f88393bb0ff0d738defa271729a8aa9b8de24ed13bc6bd27014f2daf5"
