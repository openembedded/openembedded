SRC_URI = "${GNU_MIRROR}/autoconf/autoconf-${PV}.tar.bz2 \
	   file://program_prefix.patch;patch=1"
LICENSE = "GPL"
DESCRIPTION = "A package of M4 macros to produce scripts to \
automatically configure sourcecode." 

PR = "r1"
RRECOMMENDS_${PN} = "automake"
SECTION = "devel"
inherit autotools
