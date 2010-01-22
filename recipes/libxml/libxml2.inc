DESCRIPTION = "GNOME XML Parser library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"

SRC_URI = "ftp://xmlsoft.org/libxml2/libxml2-${PV}.tar.gz"

INC_PR = "r2"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--without-python --without-debug --without-legacy --with-catalog --with-docbook --with-c14n"

export LDFLAGS += "-ldl"

do_stage() {
	autotools_stage_all
	install -d ${STAGING_DATADIR}/aclocal/
	install -d ${STAGING_BINDIR_CROSS}

 	install -m 0644 libxml.m4 ${STAGING_DATADIR}/aclocal/
	#this is need it by php during its install
	install -m 0755 xml2-config ${STAGING_BINDIR_CROSS}
}

DEBIANNAME_${PN} = "libxml2"

PACKAGES =+ "${PN}-utils"
FILES_${PN} = "${libexecdir}/* ${libdir}/lib*${SOLIBS} \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_libdir}/*${SOLIBS} \
            ${datadir}/${PN} ${libdir}/${PN}/* \
            ${datadir}/pixmaps ${datadir}/applications \
            ${datadir}/idl ${datadir}/omf ${datadir}/sounds \
            ${libdir}/bonobo/servers"

FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN}-utils = "${bindir}/xmllint ${bindir}/xmlcatalog ${libdir}/*.sh"
