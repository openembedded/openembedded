require popt.inc

DEPENDS = "gettext virtual/libintl"

PR = "r1"

inherit autotools

SRC_URI = "http://freshmeat.net/redir/popt/72854/url_bz2/popt-${PV}.tar.gz \
	   file://iconv.patch;patch=1 \
	  "

do_stage() {
	oe_libinstall -a -so libpopt ${STAGING_LIBDIR}
	install -m 0644 popt.h ${STAGING_INCDIR}
}


