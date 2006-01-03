DESCRIPTION = "Lossless data compression library"
HOMEPAGE = "http://www.oberhumer.com/opensource/lzo/"
LICENSE = "GPLv2"
SECTION = "libs"
PRIORITY = "optional"
PR = "r13"

SRC_URI = "http://www.oberhumer.com/opensource/lzo/download/lzo-${PV}.tar.gz"

inherit autotools 

EXTRA_OECONF = "--enable-shared"

#do_configure () {
#	# override this function to avoid the autoconf/automake/aclocal/autoheader
#	# calls for now
#	gnu-configize
#	oe_runconf
#}

do_stage() {
	autotools_stage_all
}
