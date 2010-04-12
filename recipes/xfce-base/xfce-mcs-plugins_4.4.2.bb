# xfce-mcs-plugins OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION = "Common XFCE4 configuration plugins."
DEPENDS = "libxfcegui4 xfce-mcs-manager gtk+"
SECTION = "x11"

inherit xfce

PACKAGES += "${PN}-mcs-plugins"
FILES_${PN}-mcs-plugins = "${libdir}/xfce4/mcs-plugins/*.so"

SRC_URI[md5sum] = "77fcc929058de530d4f91eb25de851a1"
SRC_URI[sha256sum] = "e16610264256248bfd8ca227c7861000abf0c323611ad34913b06c41af0c9be5"
