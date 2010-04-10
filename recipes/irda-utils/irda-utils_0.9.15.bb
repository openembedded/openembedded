SECTION = "base"
DESCRIPTION = "Provides common files needed to use IrDA. \
IrDA allows communication over Infrared with other devices \
such as phones and laptops."
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/irda/irda-utils-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://m4.patch;patch=1"

export SYS_INCLUDES="-I${STAGING_INCDIR}"
BROKEN = "1"

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

SRC_URI[md5sum] = "b69b75464d6ee72e6600a8459d9b68ac"
SRC_URI[sha256sum] = "27df093409e65279b5cf60777c3310feb50a522bebd4f5038cfebe41a7a46809"
