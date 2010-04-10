HOMEPAGE = "http://www.vanheusden.com/rsstail/"
DESCRIPTION = "RSSTail is a tail-like RSS reader: it monitors an RSS feed and if it detects a new entry it will emit only that new entry."
LICENSE = "GPLv2"

DEPENDS = "libmrss"

PR = "r0"

inherit autotools

SRC_URI = "http://www.vanheusden.com/rsstail/rsstail-${PV}.tgz"

do_install_prepend() {
  install -d ${D}${bindir} ${D}${mandir}/man1
}

do_stage() {
	:
}

SRC_URI[md5sum] = "1558fc8b0c9a8cb79e421f783f1ffc40"
SRC_URI[sha256sum] = "242b3d5807e7bd753531fb836395afe18efe948174ea1ae54a4b7baba7a058fe"
