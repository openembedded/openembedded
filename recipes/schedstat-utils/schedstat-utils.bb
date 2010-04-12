DESCRIPTION = "Simple utilities for using the information exposed by \
'schedstats', the kernel patches for obtaining scheduler statistics."

SRC_URI = "http://eaglet.rain.com/rick/linux/schedstat/v10/latency.c;name=archive \
	   http://eaglet.rain.com/rick/linux/schedstat/v10/stats-10.pl;name=stats"
S = "${WORKDIR}/eaglet.rain.com"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} latency.c -o stats-latency
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 stats-latency ${D}${sbindir}/
	install -m 0755 stats-10.pl ${D}${sbindir}/
}

PACKAGES = "${PN}-dbg schedstat-utils \
	    schedstat-utils-latency \
	    schedstat-utils-perl"
RDEPENDS_${PN} = "schedstat-utils-latency schedstat-utils-perl"
RDEPENDS_schedstat-utils-perl += "perl"
FILES_${PN} = ""
FILES_schedstat-utils-latency = "${sbindir}/stats-latency"
FILES_schedstat-utils-perl = "${sbindir}/stats-10.pl"

SRC_URI[archive.md5sum] = "56a9be3b788ad32a169069f332ebf0f3"
SRC_URI[archive.sha256sum] = "cc1fc10fe3e8473efd3af315a47500d646665554fe6fe5993028adb1f189334b"
SRC_URI[stats.md5sum] = "9c05c1831449219d063e803e3cf1dd88"
SRC_URI[stats.sha256sum] = "06e1f846b47c3b3b702b65489bc7d4d4c6b9f499609f4aec4556cb5046729202"
