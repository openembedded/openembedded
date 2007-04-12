DESCRIPTION = "GPE owner information dialog"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"
PR = "r1"
PV = "0.28+svn-${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "${GPE_SVN} \
	    file://svn-build.patch;patch=1" 

S = "${WORKDIR}/${PN}"

do_stage () {
        oe_libinstall -a libgpe-ownerinfo ${STAGING_LIBDIR}
        install -m 0644 gpe-ownerinfo.h ${STAGING_INCDIR}/
}
