require autoconf.inc
SRC_URI = "${GNU_MIRROR}/autoconf/autoconf-${PV}.tar.gz"
PR = "r1"
EXTRA_OECONF = "--program-transform-name=s/\$/2.13/"
EXTRA_OEMAKE = 'acdatadir="${datadir}/autoconf-${PV}" infodir="${datadir}/autoconf-${PV}/info"'
