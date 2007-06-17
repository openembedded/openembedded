require libmatchbox.inc
PR = "r1"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/${PV}/${PN}-${PV}.tar.gz \
	   file://16bppfixes-2.patch;patch=1 \
           file://check.m4"

do_configure_prepend () {
	mv ${WORKDIR}/check.m4 ${S}/
}
