DESCRIPTION = "Tool to edit the Redboot FIS partition layout from userspace"
PR = "r1"
DEPENDS = "boost"

SRC_URI = "http://svn.chezphil.org/utils/trunk/fis.cc \
	   svn://svn.chezphil.org/;module=libpbe;proto=http"

do_compile() {
	${CXX} -Os -W -I${STAGING_INCDIR} -I${WORKDIR}/libpbe/trunk/include -o fis ${WORKDIR}/fis.cc \
	${WORKDIR}/libpbe/trunk/src/Exception.cc ${WORKDIR}/libpbe/trunk/src/utils.cc
}

do_install() {
	${STRIP} ${WORKDIR}/fis-${PV}/fis

	install -d ${D}/${sbindir}
	install -m 755 ${WORKDIR}/fis-${PV}/fis ${D}/${sbindir}
}
