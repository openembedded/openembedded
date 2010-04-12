HOMEPAGE = "http://linux.duke.edu/projects/yum/"

SRC_URI = "http://linux.duke.edu/projects/yum/download/3.2/yum-${PV}.tar.gz \
           file://hacks.patch;patch=1 \
           file://paths.patch;patch=1 \
	   file://yum-install-recommends.py \
	   file://extract-postinst.awk"
PR = "r7"

DEPENDS = "rpm-native python-native python-iniparse-native intltool-native \
	   python-urlgrabber-native yum-metadata-parser-native libxml2-native"

S = "${WORKDIR}/yum-${PV}"

inherit autotools native

do_compile_append () {
	sed -e 's#!/usr/bin/python#!${bindir}/python#' -e 's#/usr/share#${datadir}#' -i ${S}/bin/yum.py
	sed -e 's#!/usr/bin/python#!${bindir}/python#' -e 's#/usr/share#${datadir}#' -i ${S}/bin/yum-updatesd.py
}

do_install_append () {
	install -d ${STAGING_BINDIR}/
	install ${WORKDIR}/extract-postinst.awk ${STAGING_BINDIR}/
	install ${WORKDIR}/yum-install-recommends.py ${STAGING_BINDIR}/
}

SRC_URI[md5sum] = "711f518cb72a698ed98a21a374a4585e"
SRC_URI[sha256sum] = "8b3f300602ce021bf5202496b98271814935f45f3bf3c6730ba4e789b2f323c8"
