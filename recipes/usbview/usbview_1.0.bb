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
