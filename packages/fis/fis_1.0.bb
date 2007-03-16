DESCRIPTION = "Tool to edit the Redboot FIS partition layout from userspace"
PR = "r1"
DEPENDS = "boost"

SRC_URI = "http://svn.chezphil.org/utils/trunk/fis.cc \
	   svn://svn.chezphil.org/;module=libpbe;proto=http"

PACKAGES =+ "fis-static"
FILES_${PN}-static = "${sbindir}/fis-static"
FILES_${PN} = "${sbindir}/fis"

do_compile() {
	${CXX} -Os -W -I${STAGING_INCDIR} -I${WORKDIR}/libpbe/trunk/include -o fis ${WORKDIR}/fis.cc \
	${WORKDIR}/libpbe/trunk/src/Exception.cc ${WORKDIR}/libpbe/trunk/src/utils.cc

	# Work around boost threading issue when compiling static
	# We're singlethreading anyway

	echo "#define BOOST_SP_DISABLE_THREADS" > ${WORKDIR}/tmpfile
	cat ${WORKDIR}/tmpfile ${WORKDIR}/fis.cc > ${WORKDIR}/fis.new
	mv ${WORKDIR}/fis.new ${WORKDIR}/fis.cc
	rm ${WORKDIR}/tmpfile

	${CXX} -Os -W -static -I${STAGING_INCDIR} -I${WORKDIR}/libpbe/trunk/include -o fis-static ${WORKDIR}/fis.cc \
	${WORKDIR}/libpbe/trunk/src/Exception.cc ${WORKDIR}/libpbe/trunk/src/utils.cc
}

do_install() {
	${STRIP} ${WORKDIR}/fis-${PV}/fis-static
	${STRIP} ${WORKDIR}/fis-${PV}/fis

	install -d ${D}/${sbindir}
	install -m 755 ${WORKDIR}/fis-${PV}/fis-static ${D}/${sbindir}
	install -m 755 ${WORKDIR}/fis-${PV}/fis ${D}/${sbindir}
}
