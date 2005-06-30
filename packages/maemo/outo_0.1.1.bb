DESCRIPTION = "Outo Unit Tester by Otso"
LICENSE	=	"LGPL"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

SRC_URI =	"http://repository.maemo.org/pool/maemo/ossw/source/o/outo/outo_${PV}.orig.tar.gz \
			http://repository.maemo.org/pool/maemo/ossw/source/o/outo/outo_0.1.1-2.diff.gz;patch=1;pnum=1"
S = "${WORKDIR}/outo-0.1.1-20030806.orig"

inherit pkgconfig autotools


do_stage() {
		install -d ${STAGING_INCDIR}
		install -m 644 include/outo.h ${STAGING_INCDIR} 
}
