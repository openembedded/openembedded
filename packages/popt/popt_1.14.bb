require popt.inc

DEPENDS = "gettext-native virtual/libintl"

PR = "r1"

inherit autotools

SRC_URI = "http://rpm5.org/files/popt/popt-${PV}.tar.gz" 
	  

do_stage() {
	oe_libinstall -a -so libpopt ${STAGING_LIBDIR}
	install -m 0644 popt.h ${STAGING_INCDIR}
}


