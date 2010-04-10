# usbview .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

DESCRIPTION="USBView is a GTK program that displays the topography of the \
	devices that are plugged into the USB bus on a Linux machine."
HOMEPAGE="http://www.kroah.com/linux-usb/"
LICENSE="GPL"

SRC_URI="http://www.kroah.com/linux-usb/${PN}-${PV}.tar.gz \
	file://gtk2.patch;patch=1"

DEPENDS="gtk+ pango glib-2.0 cairo atk"

inherit autotools

SRC_URI[md5sum] = "2ac1bdae03a858b965e895b211a75ad7"
SRC_URI[sha256sum] = "7a7add52242142f37a7d220c76dfe77090f6592eacdf796e3d07fa61415340fd"
