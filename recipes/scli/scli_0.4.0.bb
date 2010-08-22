DESCRIPTION = "SNMP Command Line Interface"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "gsnmp readline libxml2 ncurses"
PR = "r1"

SRC_URI = "ftp://ftp.ibr.cs.tu-bs.de/pub/local/scli/scli-${PV}.tar.gz"

SRC_URI[md5sum] = "486c92c76059a35c87e88edf24cbf804"
SRC_URI[sha256sum] = "308511589260d3da9bc5817ace363180070ac83ccba9231b7b9a01e1b0c29fe1"

inherit autotools
