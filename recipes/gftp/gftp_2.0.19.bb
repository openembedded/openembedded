# gftp OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Free multithreaded file transfer client (FTP/HTTP/SSH)."
HOMEPAGE = "http://www.gftp.org/"
SECTION = "x11/network"
LICENSE = "GPL"
DEPENDS = "gtk+ openssl"

inherit autotools

SRC_URI = "http://www.gftp.org/gftp-${PV}.tar.bz2 \
           file://configure.patch;patch=1"

SRC_URI[archive.md5sum] = "5183cb4955d94be0e03c892585547c64"
SRC_URI[archive.sha256sum] = "5306a46be96d6f4d23906cb1836fb3d732039621a6c7fcfa921acc21ac110bfd"

EXTRA_OECONF = "--disable-textport"
