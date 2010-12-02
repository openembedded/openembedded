require bug-osgi.inc
DEPENDS += "com.buglabs.common felix-configadmin com.buglabs.osgi.http"
RDEPENDS += "com.buglabs.osgi.http"
DEPENDS += "servlet2.3"
EXTRA_CP += "servlet-2.3.1"
PR = "${INC_PR}.4+svnr${SRCREV}"

do_compile() {

  mkdir -p build
  oe_makeclasspath cp -s ${DEPENDS} ${EXTRA_CP}
  cp=$cp:${STAGING_DIR_JAVA}/osgi.jar

  echo "JAVAC CLASSPATH ---------------"
  echo $cp | awk 'BEGIN {FS=":"} {split($0,a,":"); for (i=1; i<=NF; i++) print a[i]; }'
  echo "-------------------------"

  javac -sourcepath . -cp $cp -d build `find . -name \*.java`
  find ${S}/static -name \*svn\* | xargs rm -fr
  cp -r ${S}/static build/ 
}
