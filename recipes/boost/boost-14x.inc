# The Boost web site provides free peer-reviewed portable
# C++ source libraries. The emphasis is on libraries which
# work well with the C++ Standard Library. The libraries are
# intended to be widely useful, and are in regular use by
# thousands of programmers across a broad spectrum of applications.
DESCRIPTION = "Free peer-reviewed portable C++ source libraries"
HOMEPAGE = "http://www.boost.org/"
SECTION = "libs"
DEPENDS = "zlib bzip2 python expat"
PRIORITY = "optional"
LICENSE = "Boost Software License"
INC_PR = "r8"

ARM_INSTRUCTION_SET = "arm"
BOOST_VER = "${@"_".join(bb.data.getVar("PV",d,1).split("."))}"
BOOST_MAJ = "${@"_".join(bb.data.getVar("PV",d,1).split(".")[0:2])}"
BOOST_P = "boost_${BOOST_VER}"

inherit cmake

EXTRA_OECMAKE = "-DBUILD_SHARED=ON \
		 -DBUILD_MULTI_THREADED=ON \
		 -DBUILD_RELEASE=ON \
                 -DBUILD_DEBUG=OFF \
		 -DWITH_MPI:BOOL=OFF \
		 -DINSTALL_VERSIONED:BOOL=OFF \
		"

BOOST_LIBS = "\
	date_time \
	filesystem \
	graph \
	iostreams \
	program_options \
        python \
	regex \
        serialization \
	signals \
	system \
	test \
	thread \
	"

# FIXME: for some reason this fails on powerpc
#BOOST_LIBS += "serialization"

# To enable python, uncomment the following:
#BOOST_LIBS += "python"
#DEPENDS += "python"
#PYTHON_ROOT = "${STAGING_DIR_HOST}/${layout_prefix}"
#PYTHON_VERSION = "2.5"

S = "${WORKDIR}/${BOOST_P}"

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

