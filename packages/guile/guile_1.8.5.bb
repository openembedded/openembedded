DESCRIPTION = "Guile is an interpreter for the Scheme programming language, \
packaged as a library which can be incorporated into your programs."
HOMEPAGE = "http://www.gnu.org/software/guile/guile.html"
SECTION = "devel/scheme"
DEPENDS = "guile-native gmp libtool"
LICENSE = "GPL"

PR = "r3"

SRC_URI = "http://ftp.gnu.org/pub/gnu/guile/guile-${PV}.tar.gz \
           file://configure-fix.patch;patch=1 "

inherit autotools binconfig

acpaths = "-I ${S}/guile-config"

EXTRA_OECONF = " \
		--without-threads \
		--without-included-ltdl \
               "		

do_compile() {
	(cd libguile; oe_runmake CC="${BUILD_CC}" CFLAGS="${BUILD_CFLAGS}" LDFLAGS="${BUILD_LDFLAGS}" guile_filter_doc_snarfage)
	oe_runmake preinstguile="`which guile`"
        
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
               -e s:-L/usr/lib::g \
               -e s:-isystem/usr/include::g \
               -e s:,/usr/lib:,\$\{libdir\}:g \
                  guile-1.8.pc
}

do_stage() {
	autotools_stage_all
}

