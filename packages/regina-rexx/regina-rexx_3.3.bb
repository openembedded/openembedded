DESCRIPTION = "A cross-platform REXX interpreter"
SECTION = "devel/rexx"
LICENSE = "GPL"
HOMEPAGE = "http://regina-rexx.sf.net"
DEPENDS = "regina-rexx-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/regina-rexx/regina33.zip \
           file://use-proper-host-tools.patch;patch=1"
S = "${WORKDIR}"

inherit autotools

PARALLEL_MAKE = ""

# need to use configure script built by ancient autotools
do_configure() {
	gnu-configize
	oe_runconf
}

do_compile() {
	oe_runmake STAGING_BINDIR="${STAGING_BINDIR}"
}

do_install() {
	oe_runmake install bindir="${D}${bindir}" libdir="${D}${libdir}" includedir="${D}${includedir}" \
                           sharedir="${D}${datadir}" mandir="${D}${mandir}" sysconfdir="${D}${sysconfdir}" \
                           STAGING_BINDIR="${STAGING_BINDIR}"
}

FILES_${PN} += "${datadir}"

