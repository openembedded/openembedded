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
