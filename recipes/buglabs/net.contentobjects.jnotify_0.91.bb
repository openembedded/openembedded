DESCRIPTION = "JNotify library with OSGi extensions."

SRCREV = "12121"

SRC_URI = "svn://bugcamp.net/bug/trunk;module=${PN};proto=svn"

DEPENDS = "fastjar-native virtual/java-initial openjdk-6"

#inherit jni-library bug-java-library
inherit bug-java-library

PACKAGES = ${PN}
S = "${WORKDIR}/${PN}"
# INHIBIT_PACKAGE_STRIP=1
PR="r2"

addtask jar_package after do_compile before do_install

do_compile() {
  mkdir -p build
  oe_makeclasspath cp -s ${DEPENDS} ${EXTRA_CP}
  cp=$cp:${WORKDIR}/files/osgi.jar

  echo "--- JAVAC CLASSPATH ---------------"
  echo $cp | awk 'BEGIN {FS=":"} {split($0,a,":"); for (i=1; i<=NF; i++) print a[i]; }'
  echo "-------------------------"

  javac -sourcepath . -cp $cp -d build `find . -name \*.java`
}

do_jni_compile() {
        cd ${S}/src/c/Release
        oe_runmake all
}

do_jni_install() {
  install -d ${D}${JNI_LIB_DIR}
  install ${S}/src/c/Release/libjnotify.so ${D}${JNI_LIB_DIR}
}

do_jar_package() {
  # mkdir META-INF
  echo 'Manifest-Version: 1.0' > META-INF/MANIFEST.MF
  echo 'Bundle-Vendor: Bug Labs, Inc.' >> META-INF/MANIFEST.MF
  echo 'Bundle-Author: Omry Yadan (http://jnotify.sourceforge.net/)' >> META-INF/MANIFEST.MF
  echo 'Bundle-Name: net.contentobjects.jnotify' >> META-INF/MANIFEST.MF
  echo 'Bundle-License: LGPL' >> META-INF/MANIFEST.MF
  echo 'Bundle-SymbolicName: net.contentobjects.jnotify' >> META-INF/MANIFEST.MF
  echo 'Bundle-Version: ${DISTRO_VERSION}.${PR}' >> META-INF/MANIFEST.MF
  echo 'Bundle-BuildDate: ${DATETIME}' >> META-INF/MANIFEST.MF
  echo 'Export-Package: net.contentobjects.jnotify' >> META-INF/MANIFEST.MF

  fastjar -0 -m META-INF/MANIFEST.MF -C build -c -f ${JARFILENAME} .
}

FILES_${PN} += "/usr/share/java/${PN}.jar"
FILES_${PN} += "/usr/share/java/${P}.jar"
FILES_${PN} += "/usr/lib/jni/libjnotify.so"
FILES_${PN} += "${JNI_LIB_DIR}/${PN}.so"
