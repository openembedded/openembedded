#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see http://www.opensource.org/licenses/mit-license.php for a copy of the license)
#
# Filename: fbset_2.1.bb
# Date: 28-May-06

DESCRIPTION = "The fbset console tool"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = ""
LICENSE = "GPL"

######################################################################################

SRC_URI = "http://ftp.debian.org/debian/pool/main/f/fbset/fbset_2.1.orig.tar.gz \
	   file://makefile.patch;patch=1"

######################################################################################

PR = "r1"
PARALLEL_MAKE=""

######################################################################################

inherit autotools 

######################################################################################

do_install() {
	install -d ${D}/usr/sbin ${D}/usr/share/man/man8 ${D}/usr/share/man/man5
	
	install -m 0755 ${WORKDIR}/${P}/fbset ${D}/usr/sbin/fbset.real

	install -m 0644 ${WORKDIR}/${P}/*.5 ${D}/usr/share/man/man5
	install -m 0644 ${WORKDIR}/${P}/*.8 ${D}/usr/share/man/man8
}

######################################################################################

pkg_postinst_${PN}() {
	update-alternatives --install /usr/sbin/fbset fbset /usr/sbin/fbset.real 55	
}

pkg_postrm_${PN}() { 
	update-alternatives --remove fbset /usr/sbin/fbset.real
}                                                                               
