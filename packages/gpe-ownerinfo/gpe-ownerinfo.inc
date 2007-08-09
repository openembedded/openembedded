inherit gpe

DESCRIPTION = "GPE owner information dialog"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"

do_stage () {
	oe_libinstall -a libgpe-ownerinfo ${STAGING_LIBDIR}
	install -m 0644 gpe-ownerinfo.h ${STAGING_INCDIR}/
}

