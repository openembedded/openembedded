DESCRIPTION = "GSM Audio Library"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Luca De Cicco <ldecicco@gmx.net>"
#DEPENDS = ""
LICENSE = "libgsm"
inherit pkgconfig gpe

SRC_URI = "ftp://ftp.cs.tu-berlin.de/pub/local/kbs/tubmik/gsm/gsm-${PV}.tar.gz \
 file://${FILESDIR}/libgsm_patch;patch=1;pnum=0"

S = "${WORKDIR}/gsm-1.0-pl10/"

headers = "gsm.h"

do_stage () {
        oe_libinstall -a -C lib libgsm ${STAGING_LIBDIR}
	mkdir -p ${STAGING_INCDIR}/gsm
	for h in ${headers}; do
		install -m 0644 ${S}/inc/$h ${STAGING_INCDIR}/gsm/$h
	done
}

#do_install () {
#	gpe_do_install
#	oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
#}
