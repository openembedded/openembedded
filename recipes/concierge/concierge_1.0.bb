DESCRIPTION = "A fast, lightweight OSGi R3 framework implementation"
LICENSE = "BSD"
DEPENDS = "fastjar-native"

SRCREV = "246"
PV = "1.0+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://concierge.svn.sourceforge.net/svnroot/concierge/tags/Concierge/1.0.0/trunk;module=framework;proto=http;localdir=framework \
                   file://fix-EE-string.patch \
                   file://run-in-place.patch;striplevel=1 \
                  "
S = "${WORKDIR}/framework"

inherit bug-java-library

do_compile() {
  mkdir -p build
  javac -sourcepath src/main/java -d build `find src/main/java -name \*.java`
  fastjar -0 -C build -c -f ${JARFILENAME} .
}

PACKAGE_ARCH = "all"
# override java-library's naming conventions
PACKAGES = "${PN}"

FILES_${PN} += "${datadir_java}/${PN}.jar"
