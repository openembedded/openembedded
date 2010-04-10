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


SRC_URI[md5sum] = "84c0a051ba5358546a9c0e393095ab91"
SRC_URI[sha256sum] = "7cf45008810ca894b085ae0eb1a0071f0cb6989dd9ce35cfcd617fedf7018c7f"
