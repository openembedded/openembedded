# Copyright (C) 2010, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license

DESCRIPTION = "FreeRDP RDP client"
HOMEPAGE = "http://freerdp.sourceforge.net"
DEPENDS = "virtual/libx11 openssl"
SECTION = "x11/network"
LICENSE = "GPL"

INC_PR = "r1"

inherit pkgconfig autotools

FILES_${PN}-dev += "${libdir}/freerdp/*.a ${libdir}/freerdp/*.la"
