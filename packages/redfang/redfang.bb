SECTION = "unknown"
SRC_URI = "http://packetstormsecurity.org/wireless/redfang.2.5.tar.gz \ 
    	   file://Makefile.patch;patch=1;pnum=0"

DEFAULT_PREFERENCE="-1"
PV="2.5"

CFLAGS_prepend = "-I${STAGING_INCDIR}/bluetooth"

LDFLAGS_prepend = "-L${STAGING_LIBDIR} -lbluetooth -lpthread "

S = "${WORKDIR}/redfang-2.5"
LICENSE = "GPL"
do_compile() {
	oe_runmake all
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/fang ${D}${bindir}
}

