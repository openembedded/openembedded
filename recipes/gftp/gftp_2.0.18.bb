# gftp OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Free multithreaded file transfer client (FTP/HTTP/SSH)."
HOMEPAGE="http://www.gftp.org/"
SECTION = "x11/network"
LICENSE="GPL"
PR = "r4"

SRC_URI="http://www.gftp.org/gftp-${PV}.tar.bz2 \
	 file://configure.patch;patch=1 \
	 file://gftp-2.0.18-188252.patch;patch=1 \
	 file://gftp-2.0.18-ipv6.patch;patch=1;pnum=2 \
	 file://gftp-2.0.18-ssh2-read.patch;patch=1 \
	 file://gftp-2.0.18-ssl-wildcardcert.patch;patch=1;pnum=0 \
	 file://gftp-2.0.18-mkinstalldir.patch;patch=1 "

DEPENDS="gtk+ openssl"

inherit autotools

EXTRA_OECONF="--disable-textport"

SRC_URI[md5sum] = "44b19442d06f6dc68c7211d66029d826"
SRC_URI[sha256sum] = "8145e18d1edf13e8cb6cd7a69bb69de5c46307086997755654488fb8282d38a2"
