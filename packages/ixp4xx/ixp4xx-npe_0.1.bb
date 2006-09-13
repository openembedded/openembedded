DESCRIPTION = "Firmware for the IXP4xx line of devices"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp420.htm"
LICENSE = "http://www.intel.com/design/network/swsup/np_sla/ixp400.htm"
LICENSE_HOMEPAGE = "http://www.intel.com/design/network/products/npfamily/ixp425swr1.htm"
PR = "r1"

# You must download the following software to your OpenEmbedded downloads
# directory before using this package:
#
#       IPL_ixp400AccessLibrary-2_1.zip
#       IPL_ixp400NpeLibrary-2_1.zip
#
# To do this go to the LICENSE_HOMEPAGE above, register/login (using a
# web browser which is supported by the login page), this will give you
# access to the web page from which you can download the software - you
# need the: "Intel® IXP400 Software and RedBoot* Boot Loader" and, from
# this the "Intel Hardware Access Software" and "NPE Microcode" (both
# versions 2.1, encryption is not required.)
#
# Store the files with the names given below in your downloads directory
# and store the 32 character md5sum of the file in a file of the same
# name with the additional extension .md5:
#
#       IPL_ixp400AccessLibrary-2_1.zip.md5
#       IPL_ixp400NpeLibrary-2_1.zip.md5
#

SRC_URI = "http://www.intel.com/Please-Read-The-BB-File/IPL_ixp400AccessLibrary-2_1.zip"
inherit native
S = ${WORKDIR}/ixp400_xscale_sw/src/npeDl

do_compile() {
	${CC} -Wall IxNpeMicrocode.c -o IxNpeMicrocode
	${S}/IxNpeMicrocode 
}

do_install() {
	install -d ${D}/lib/firmware
	install ${S}/NPE-B.010c0200 ${D}/lib/firmware/
}
