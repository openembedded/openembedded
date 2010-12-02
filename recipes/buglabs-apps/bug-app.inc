require ../buglabs-osgi/bug-osgi.inc

PR = "${INC_PR}.1"

SRC_URI = "file://${FILE} "

FILES_${PN} += "/usr/share/java/apps/${PN}.jar"
FILES_${PN} += "/usr/share/java/apps/${P}.jar"

S = "${WORKDIR}"

datadir_java="/usr/share/java/apps"

do_compile() {
  mkdir -p build
  oe_makeclasspath cp -s ${DEPENDS} ${EXTRA_CP}
  cp=$cp:${STAGING_DIR_JAVA}/osgi.jar

  echo "JAVAC CLASSPATH ---------------"
  echo $cp | awk 'BEGIN {FS=":"} {split($0,a,":"); for (i=1; i<=NF; i++) print a[i]; }'
  echo "-------------------------"

  javac -sourcepath . -cp $cp -d build `find . -name \*.java`
  pwd
  ls -haltr ${WORKDIR}/`basename ${SRC_LINK}`
  
  unzip -o ${WORKDIR}/`basename ${SRC_LINK}` -d build -x *.class -x *.java
  fastjar -0 -m ./build/META-INF/MANIFEST.MF -C build -c -f ${JARFILENAME} .
}

do_jar_package() {
    :
}

do_fetch_and_unpack() {

cd ${WORKDIR}
rm -rf META-INF OSGI-OPT
wget --retry-connrefused -t 0 ${SRC_LINK}
unzip -o `basename ${SRC_LINK}` -d ${PN} -x *.class

}

addtask fetch_and_unpack after do_unpack before do_patch

PACKAGE_ARCH = "all"
