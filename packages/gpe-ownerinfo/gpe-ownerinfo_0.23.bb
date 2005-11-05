inherit gpe

DESCRIPTION = "GPE owner information dialog"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ libgpewidget"
LICENSE = "GPL"
PR = "r1"

do_stage () {
	oe_libinstall -a libgpe-ownerinfo ${STAGING_LIBDIR}
	install -m 0644 gpe-ownerinfo.h ${STAGING_INCDIR}/ 
}
