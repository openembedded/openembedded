# xfce-calendar OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

require ${PN}.inc

SRC_URI = "http://www.us.xfce.org/archive/xfce/${XFCE_VERSION}/src/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "d2e2c8e010cca708295aeaf621086205"
SRC_URI[sha256sum] = "ad8d141d23f48736180d3913a0600d1733d71a341fd1889e69f727a998cfa0a3"

PACKAGES += " ${PN}-mcs-plugins"
FILES_${PN}-mcs-plugins += "${libdir}/xfce4/mcs-plugins/*.so"

