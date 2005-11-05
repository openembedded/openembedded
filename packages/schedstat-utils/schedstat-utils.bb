DESCRIPTION = "Simple utilities for using the information exposed by \
'schedstats', the kernel patches for obtaining scheduler statistics."

SRC_URI = "http://eaglet.rain.com/rick/linux/schedstat/v10/latency.c \
	   http://eaglet.rain.com/rick/linux/schedstat/v10/stats-10.pl"
S = "${WORKDIR}/eaglet.rain.com"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} latency.c -o stats-latency
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 stats-latency ${D}${sbindir}/
	install -m 0755 stats-10.pl ${D}${sbindir}/
}

PACKAGES = "schedstat-utils \
	    schedstat-utils-latency \
	    schedstat-utils-perl"
RDEPENDS_${PN} = "schedstat-utils-latency schedstat-utils-perl"
RDEPENDS_schedstat-utils-perl += "perl"
FILES_${PN} = ""
FILES_schedstat-utils-latency = "${sbindir}/stats-latency"
FILES_schedstat-utils-perl = "${sbindir}/stats-10.pl"
