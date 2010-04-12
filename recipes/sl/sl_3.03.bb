DESCRIPTION = "Corrects you if you type sl by mistake"
SECTION = "console/games"
LICENSE = "unknown"
DEPENDS = "ncurses"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/s/sl/sl_3.03.orig.tar.gz;name=archive \
           http://archive.ubuntu.com/ubuntu/pool/universe/s/sl/sl_3.03-14.diff.gz;patch=1;name=patch"

S = "${WORKDIR}/${P}.orig"

LDFLAGS += "-lncurses"

do_install() {
        install -d ${D}${bindir}
        install -m 755 sl ${D}${bindir}
}



SRC_URI[archive.md5sum] = "d0d997b964bb3478f7f4968eee13c698"
SRC_URI[archive.sha256sum] = "5986d9d47ea5e812d0cbd54a0fc20f127a02d13b45469bb51ec63856a5a6d3aa"
SRC_URI[patch.md5sum] = "bbc8f69a7add52ed30dbac276d43ef92"
SRC_URI[patch.sha256sum] = "948499164f7be0c0b12e545bf49f1ab81e4546704cb3bedc1141d31a2d6dcbe6"
