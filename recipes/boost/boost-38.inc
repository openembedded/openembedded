# The Boost web site provides free peer-reviewed portable
# C++ source libraries. The emphasis is on libraries which
# work well with the C++ Standard Library. The libraries are
# intended to be widely useful, and are in regular use by
# thousands of programmers across a broad spectrum of applications.
DESCRIPTION = "Free peer-reviewed portable C++ source libraries"
HOMEPAGE = "http://www.boost.org/"
SECTION = "libs"
DEPENDS = "boost-jam-native-3.1.17 zlib"
PRIORITY = "optional"
LICENSE = "Boost Software License"

#ARM_INSTRUCTION_SET = "arm" # we can now (cross)compile it with thumb support thanks to one of the patches
BOOST_VER = "${@"_".join(bb.data.getVar("PV",d,1).split("."))}"
BOOST_MAJ = "${@"_".join(bb.data.getVar("PV",d,1).split(".")[0:2])}"
BOOST_P = "boost_${BOOST_VER}"

S = "${WORKDIR}/${BOOST_P}"

BOOST_LIBS ?= "\
	date_time \
	filesystem \
	graph \
	iostreams \
	math \
	program_options \
	regex \
	serialization \
	signals \
	system \
	thread \
	test \
	wave \
	"

#BJAM_PYTHON = ""
# To enable python, uncomment the following:
#BOOST_LIBS += "python"
#DEPENDS += "python"
#PYTHON_ROOT = "${STAGING_DIR_HOST}/${layout_prefix}"
#PYTHON_VERSION = "2.5"
#BJAM_PYTHON += "-sPYTHON_VERSION=${PYTHON_VERSION} --with-python-root=${PYTHON_ROOT}"

# Make a package for each library, plus -dev
PACKAGES = "${PN}-dbg ${BOOST_PACKAGES}"
python __anonymous () {
    import bb
    
    packages = []
    extras = [] 
    for lib in bb.data.getVar('BOOST_LIBS', d, 1).split( ):
        pkg = "boost-%s" % lib.replace("_", "-")
        extras.append("--with-%s" % lib)
        packages.append(pkg)
        if not bb.data.getVar("FILES_%s" % pkg, d, 1):
            bb.data.setVar("FILES_%s" % pkg, "${libdir}/libboost_%s*.so*" % lib, d)
    bb.data.setVar("BOOST_PACKAGES", " ".join(packages), d)
    bb.data.setVar("BJAM_EXTRA", " ".join(extras), d)
}

# Override the contents of specific packages
FILES_boost-serialization = "${libdir}/libboost_serialization*.so* \
	${libdir}/libboost_wserialization*.so*"
FILES_boost-test = "${libdir}/libboost_prg_exec_monitor*.so \
	${libdir}/libboost_unit_test_framework*.so*"

# -dev last to pick up the remaining stuff
PACKAGES += "${PN}-dev"
FILES_${PN}-dev = "${includedir} ${libdir}/libboost_*.so ${libdir}/libboost_*.a"

# "boost" is a metapackage which pulls in all boost librabries
PACKAGES += "${PN}"
RRECOMMENDS_${PN} += "${BOOST_PACKAGES}"

# to avoid GNU_HASH QA errors added LDFLAGS to ARCH; a little bit dirty but at least it works
#TARGET_CC_ARCH += " ${LDFLAGS}" 

BJAM_TOOLS   = "toolset=gcc \
		--prefix=${prefix} \
		--exec-prefix=${exec-prefix} \
		-sNO_BZIP2=1 \
		release optimization=space \
		--layout=system \
		"

BJAM_OPTS    = '${BJAM_TOOLS} ${BJAM_PYTHON} \
		--builddir=${S}/${TARGET_SYS} \
		${BJAM_EXTRA}'

do_configure_prepend() {
	cp -f boost/config/platform/linux.hpp boost/config/platform/linux-gnueabi.hpp

	echo 'using gcc : 4.3.1 : ${CXX} : compileflags -DBOOST_SP_USE_PTHREADS -I${includedir} linkflags -L${libdir} ;' >> ${S}/tools/build/v2/user-config.jam
#       echo '#define BOOST_SP_USE_PTHREADS' >> ${S}/boost/config/user.hpp #this trick should have fixed the __sync_add_and_fetch_4  on arm <v6(has ldrex+strex) but it didn't
}

do_compile() {
	set -ex
	bjam ${BJAM_OPTS} \
		--libdir=${libdir} \
		--includedir=${includedir}
}

do_stage() {
	set -ex
	bjam ${BJAM_OPTS} \
		--libdir=${STAGING_LIBDIR} \
		--includedir=${STAGING_INCDIR} \
		install
}

do_install() {
	set -ex
	bjam ${BJAM_OPTS} \
		--libdir=${D}${libdir} \
		--includedir=${D}${includedir} \
		install
}
