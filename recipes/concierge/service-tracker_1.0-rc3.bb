DESCRIPTION = "OSGi R3 ServiceTracker classes"
HOMEPAGE = "http://concierge.sourceforge.net"
LICENSE = "BSD"
DEPENDS = "fastjar-native concierge"

SRCREV = "220"
PV = "1.0+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://concierge.svn.sourceforge.net/svnroot/concierge/tags/Concierge/1.0.0.RC3/;module=bundles/service_tracker;proto=http;localdir=${PN} \
        file://files/service-tracker-MANIFEST.MF \
"

S = "${WORKDIR}/bundles/service_tracker"

inherit bug-java-library

do_compile() {
  mkdir -p build
  oe_makeclasspath cp -s ${DEPENDS} ${EXTRA_CP}
  echo "JAVAC CLASSPATH ---------------"
  echo $cp | awk 'BEGIN {FS=":"} {split($0,a,":"); for (i=1; i<=NF; i++) print a[i]; }'
  echo "-------------------------"
  javac -sourcepath src/main/java -cp $cp -d build `find src/main/java -name \*.java`
  fastjar -m ${WORKDIR}/files/service-tracker-MANIFEST.MF -C build -c -f ${JARFILENAME} .
  fastjar -C src/main/java -u -f ${JARFILENAME} .
}

PACKAGE_ARCH = "all"
# override java-library's naming conventions
PACKAGES = "${PN}"

FILES_${PN} += "${datadir_java}/${PN}.jar"
FILES_${PN} += "${datadir_java}/${P}.jar"
