require autoconf.inc
SRC_URI = "${GNU_MIRROR}/autoconf/autoconf-${PV}.tar.gz"
EXTRA_OECONF = "--program-transform-name=s/\$/2.13/"
EXTRA_OEMAKE = 'acdatadir="${datadir}/autoconf-${PV}" infodir="${datadir}/autoconf-${PV}/info"'
PR = "${INC_PR}.0"

SRC_URI[md5sum] = "9de56d4a161a723228220b0f425dc711"
SRC_URI[sha256sum] = "f0611136bee505811e9ca11ca7ac188ef5323a8e2ef19cffd3edb3cf08fd791e"
