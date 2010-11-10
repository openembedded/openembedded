# Copyright (C) 2010, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license

DESCRIPTION = "FreeRDP RDP client"
HOMEPAGE = "http://freerdp.sourceforge.net"
DEPENDS = "virtual/libx11 openssl libxcursor cups alsa-lib"
SECTION = "x11/network"
LICENSE = "GPL"

INC_PR = "r4"

inherit pkgconfig autotools

do_install_append() {
	rm ${D}${libdir}/freerdp/*.a ${D}${libdir}/freerdp/*.la
}
