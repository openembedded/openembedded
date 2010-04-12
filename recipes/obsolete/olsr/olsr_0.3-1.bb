LICENSE = "GPL"
SECTION = "console/network"
DESCRIPTION = "OLSR - routing protocol for wireless network"
PRIORITY = "optional"

SRC_URI = "ftp://ftp.tcweb.org/pub/tom/olsr-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "09c7ac436a8ebcdb21333f01884fd340"
SRC_URI[sha256sum] = "ce8ef14a5621ef8b62e6a4d3e171ecb88dcfbe9bb593d9e5ae0568b9eeaa20ef"
