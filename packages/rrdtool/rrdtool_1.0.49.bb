DESCRIPTION = "RRD is the Acronym for Round Robin Database. RRD is a system to store and display time-series data (i.e. network bandwidth, machine-room temperature, server load average)."
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
HOMEPAGE = "http://people.ee.ethz.ch/~oetiker/webtools/rrdtool"
LICENSE = "GPLv2"
DEPENDS = "libpng zlib"
PR = "r1"
SRC_URI = "http://people.ee.ethz.ch/~oetiker/webtools/rrdtool/pub/rrdtool-${PV}.tar.gz \
	file://perl-make-options.diff;patch=1;pnum=0"

inherit autotools

EXTRA_OECONF = "--enable-shared --enable-local-libpng --enable-local-zlib --program-prefix=''"

do_install_append() {
	install -d ${D}${docdir}/rrdtool/
	mv ${D}/usr/html ${D}${docdir}/rrdtool/
	mv ${D}/usr/doc/* ${D}${docdir}/rrdtool/
	mv ${D}/usr/examples ${D}${docdir}/rrdtool/
	mv ${D}/usr/contrib ${D}${docdir}/rrdtool/
}

FILES_${PN} += "${libdir}/perl"

DEPENDS_rddtool-perl = "perl-module-lib perl-module-dynaloader"
