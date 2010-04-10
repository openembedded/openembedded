# Copyright (C) 2007-2008, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "A cgi wrapper for embedding shell scripts into html documents"
SECTION = "console/network"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools gettext

SRC_URI[md5sum] = "906c634a2af4ac3a4b656ef4e244c4cd"
SRC_URI[sha256sum] = "d33ba27082c8bc4427ccebd8a56cf9aef190391f0361398197efb03210910f0e"
