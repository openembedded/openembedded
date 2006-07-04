DESCRIPTION = "hping is a command-line oriented TCP/IP packet \
assembler/analyzer. The interface is inspired to the ping(8) \
unix command, but hping isn't only able to send ICMP echo requests. \
It supports TCP, UDP, ICMP and RAW-IP protocols, has a traceroute \
mode, the ability to send files between a covered channel, and many \
other features."
HOMEPAGE = "http://www.hping.org/"
SECTION = "console/network"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.hping.org/hping2.0.0-rc3.tar.gz \
	   file://hping2_debian.patch;patch=1 \
	   file://hping2_configure.patch;patch=1"
S="${WORKDIR}/hping2-rc3"

#
# We've patched configure to accept byte order and ostype as env
# variables Pass those values in to stop it trying to figure it out
# by itself.
# NOTE: The configure script is not an autoconf script.
#
do_configure() {
	# endianness fun.. inspired by openssl.inc
	. ${CONFIG_SITE}
        BYTEORDER="UNKNOWN"
	if test "x$ac_cv_c_bigendian" = "xyes"; then
	    BYTEORDER="__BIG_ENDIAN_BITFIELD"
	elif test "x$ac_cv_c_littleendian" = "xyes"; then
	    BYTEORDER="__LITTLE_ENDIAN_BITFIELD"
	else
	    oefatal do_configure cannot determine endianess
	fi
	BYTEORDER="${BYTEORDER}" CONFIGOSTYPE="LINUX" ./configure
}

#
# Instead of patching the install we do things manually here
#
do_install() {
	install -m 0755 -d ${D}${sbindir} ${D}/${mandir} ${D}${docdir}/hping2
	install -m 0755 hping2 ${D}/${sbindir}
	install -m 0644 docs/hping2.8 ${D}/${mandir}
	install -m 0644 docs/HPING2-HOWTO.txt docs/HPING2-IS-OPEN \
		docs/MORE-FUN-WITH-IPID docs/SPOOFED_SCAN.txt \
		docs/AS-BACKDOOR docs/APD.txt ${D}${docdir}/hping2
}
