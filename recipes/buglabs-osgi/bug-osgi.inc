DESCRIPTION = "Bug Labs OSGi bundle: ${PN}"
LICENSE = "BSD"
DEPENDS = "felix felix-log service-tracker com.buglabs.osgi felix-configadmin"
PE = "1"

inherit bug-java-library

JARFILENAME = "${BPN}.jar"
ALTJARFILENAMES = ""

INC_PR = "r0"

SRCREV = "12839"

SRC_URI = "svn://bugcamp.net/bug/trunk;module=${PN};proto=svn "

FILES_${PN} += "/usr/share/java/bundle/${PN}.jar"
FILES_${PN} += "/usr/share/java/bundle/${P}.jar"
FILES_${PN}-dbg += "${JNI_LIB_DIR}/.debug/*"

PACKAGES = "${PN} ${PN}-dbg"

S = "${WORKDIR}/${PN}"

datadir_java = ${datadir}/java/bundle/

EXTRA_OEMAKE+="CLASSPATH_INCDIR=${STAGING_INCDIR}/classpath"

JAVAC_OPTIONS="-source 1.6"

do_compile() {
  mkdir -p build
  oe_makeclasspath cp -s ${DEPENDS} ${EXTRA_CP}
  cp=$cp:${STAGING_DIR_JAVA}/felix.jar

  echo "--- JAVAC CLASSPATH ---------------"
  echo $cp | awk 'BEGIN {FS=":"} {split($0,a,":"); for (i=1; i<=NF; i++) print a[i]; }'
  echo "-------------------------"

  javac ${JAVAC_OPTIONS} -sourcepath . -cp $cp -d build `find . -name \*.java`
}

addtask jar_package after do_compile before do_install

do_jar_package() {
  echo 'Bundle-BuildDate: ${DATETIME}' >> META-INF/MANIFEST.MF
  sed -e '/Bundle-Version/d' -e '/^$/d' META-INF/MANIFEST.MF > META-INF/MANIFEST.MF.tmp
  echo 'Bundle-Version: 2.0.${SRCREV}' >> META-INF/MANIFEST.MF.tmp
  sed '/^[ \t]*$/d' META-INF/MANIFEST.MF.tmp > META-INF/MANIFEST.MF
  fastjar -0 -m ./META-INF/MANIFEST.MF -C build -c -f ${JARFILENAME} .
}

# dummy to keep osgi.jar from being removed by java-library.bbclass
do_removebinaries() {
    :
}
