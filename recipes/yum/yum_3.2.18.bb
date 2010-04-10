HOMEPAGE = "http://linux.duke.edu/projects/yum/"
PR = "r6"

SRC_URI = "http://linux.duke.edu/projects/yum/download/3.2/yum-${PV}.tar.gz \
           file://paths.patch;patch=1 \
           file://paths2.patch;patch=1 \
	   file://yum-install-recommends.py \
	   file://extract-postinst.awk"

RDEPENDS = "python-rpm python-core python-iniparse python-urlgrabber \
            python-shell python-re python-logging python-pickle \
	    python-netserver python-compression \
	    python-unixadmin python-xml python-sqlite3 \
	    python-textutils python-fcntl python-email \
	    yum-metadata-parser"

S = "${WORKDIR}/yum-${PV}"

inherit autotools

do_compile_append () {
	sed -e 's#!/usr/bin/python#!${bindir}/python#' -e 's#/usr/share#${datadir}#' -i ${S}/bin/yum.py
	sed -e 's#!/usr/bin/python#!${bindir}/python#' -e 's#/usr/share#${datadir}#' -i ${S}/bin/yum-updatesd.py
}

do_install_append () {
	install -d ${D}${bindir}/
	install ${WORKDIR}/extract-postinst.awk ${D}${bindir}/
	install ${WORKDIR}/yum-install-recommends.py ${D}${bindir}/
}

FILES_${PN} += "${libdir}/python* ${datadir}/yum-cli"

SRC_URI[md5sum] = "711f518cb72a698ed98a21a374a4585e"
SRC_URI[sha256sum] = "8b3f300602ce021bf5202496b98271814935f45f3bf3c6730ba4e789b2f323c8"
