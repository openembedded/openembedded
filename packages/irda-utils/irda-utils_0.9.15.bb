SECTION = "base"
DESCRIPTION = "Provides common files needed to use IrDA. \
IrDA allows communication over Infrared with other devices \
such as phones and laptops."
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/irda/irda-utils-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://m4.patch;patch=1"

inherit autotools 

do_compile () {
	oe_runmake -e -C irattach
	oe_runmake -e -C irdaping
}

do_install () {
	install -d ${D}${sbindir}
	oe_runmake -C irattach ROOT="${D}" install
	oe_runmake -C irdaping ROOT="${D}" install
}
