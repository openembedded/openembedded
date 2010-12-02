require bug-osgi.inc

DEPENDS = "concierge"

PR = "${INC_PR}.4+svnr${SRCREV}"
do_compile() {
  mkdir -p build
  oe_makeclasspath cp -s ${DEPENDS} ${EXTRA_CP}
  cp=$cp:${STAGING_DIR_JAVA}/osgi.jar

  echo "JAVAC CLASSPATH ---------------"
  echo $cp | awk 'BEGIN {FS=":"} {split($0,a,":"); for (i=1; i<=NF; i++) print a[i]; }'
  echo "-------------------------"

  javac -sourcepath . -cp $cp -d build `find . -name \*.java`
  
  #copy the non java stuff in as well
  find javax/ -type f  | grep resources | grep -v svn | xargs -I %s cp -v --parents %s build/
  find javax/ -type f  | grep properties | grep -v svn | xargs -I %s cp -v --parents %s build/
  
  fastjar -0 -m ./META-INF/MANIFEST.MF -C build -c -f ${JARFILENAME} .
}
