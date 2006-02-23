include libmatchbox.inc
PR = "r2"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/${PV}/${PN}-${PV}.tar.gz \
	   file://svn-explicit-types.patch;patch=1 \
	   file://svn-autofu-xsettings.patch;patch=1 \
	   file://svn-code-misc-xsettings.patch;patch=1 \
	   file://check.m4"

do_configure_prepend () {
	mv ${WORKDIR}/check.m4 ${S}/
}
