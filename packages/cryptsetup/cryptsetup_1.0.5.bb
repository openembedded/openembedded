#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: cryptsetup_1.0.5.bb
# Date: 20071120 (YMD)

DESCRIPTION = "cryptsetup with luks support creates and manages encrypted containers and partitions"
SECTION = "console"
LICENSE = "GPL"
HOMEPAGE = "http://luks.endorphin.org/"
DEPENDS = "e2fsprogs-libs device-mapper libgcrypt popt"

RRECOMMENDS = "kernel-module-aes \
	       kernel-module-dm-crypt \
	       kernel-module-md5 \
	       kernel-module-cbc \
	       kernel-module-sha256 \
	      "
	     
######################################################################################

PR = "r1"

######################################################################################

inherit autotools 

######################################################################################

SRC_URI = "http://luks.endorphin.org/source/cryptsetup-${PV}.tar.bz2"

######################################################################################

pkg_postinst() {
	if test "x$D" = "x"
	then 
		# Work around a problem in module ipk's, where depmod is not always
		# run after installing a kernel-module.
		test -x /sbin/depmod && /sbin/depmod -a
		/bin/true
	fi
}
