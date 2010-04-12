DEPENDS = "python-native"

SRC_URI = "http://createrepo.baseurl.org/download/createrepo-${PV}.tar.gz \
           file://fix.patch;patch=1 \
           file://pathfix.patch;patch=1 "
PR = "r1"

inherit autotools native

S = "${WORKDIR}/createrepo-${PV}"

do_compile_append () {
	sed -e 's#exec /usr/share#exec ${datadir}#' -i ${S}/bin/createrepo
	sed -e 's#exec /usr/share#exec ${datadir}#' -i ${S}/bin/modifyrepo
	sed -e 's#!/usr/bin/python#!${bindir}/python#' -i ${S}/genpkgmetadata.py
	sed -e 's#!/usr/bin/python#!${bindir}/python#' -i ${S}/modifyrepo.py
}

SRC_URI[md5sum] = "0a1b1e67e3c61cda41b41a8886a90e78"
SRC_URI[sha256sum] = "21786abe80f2c06eb9bef107d8c79f50a088a894cddf793112ce0417e83be531"
