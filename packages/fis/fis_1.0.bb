DESCRIPTION = "Tool to edit the Redboot FIS partition layout from userspace"

SRC_URI = "http://svn.chezphil.org/utils/trunk/fis.cc \
	   svn://svn.chezphil.org/;module=libpbe;proto=http"

do_compile() {
	${CXX} -Os -W -I${STAGING_INCDIR} -I${WORKDIR}/libpbe/trunk/include -o fis ${WORKDIR}/fis.cc \
	${WORKDIR}/libpbe/trunk/src/Exception.cc ${WORKDIR}/libpbe/trunk/src/utils.cc
	${STRIP} ${WORKDIR}/fis-${PV}/fis
#	${CXX} -Os -W -static -I${STAGING_INCDIR} -I${WORKDIR}/libpbe/trunk/include -o fis-static ${WORKDIR}/fis.cc \
#	${WORKDIR}/libpbe/trunk/src/Exception.cc ${WORKDIR}/libpbe/trunk/src/utils.cc
#	${STRIP} ${WORKDIR}/fis-${PV}/fis-static
}