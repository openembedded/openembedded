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
	oe_runmake STAGING_BINDIR_NATIVE="${STAGING_BINDIR_NATIVE}"
}

do_install() {
	oe_runmake install bindir="${D}${bindir}" libdir="${D}${libdir}" includedir="${D}${includedir}" \
                           sharedir="${D}${datadir}" mandir="${D}${mandir}" sysconfdir="${D}${sysconfdir}" \
                           STAGING_BINDIR_NATIVE="${STAGING_BINDIR_NATIVE}"
}

FILES_${PN} += "${datadir}"


SRC_URI[md5sum] = "600da451b706c4f24451299e348da555"
SRC_URI[sha256sum] = "74f1521cc613855d26881c7b46fe72b59dafdf377cf26ec9d4f064979039a27f"
