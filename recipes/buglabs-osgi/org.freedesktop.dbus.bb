require bug-osgi.inc
PR = "${INC_PR}.3+svnr${SRCREV}"
DEPENDS += "com.buglabs.bug.jni.libmatthew"
JAVAC_OPTIONS="-source 1.5"
MSGFMT="msgfmt"
do_compile() {
       mkdir -p build
       oe_makeclasspath cp -s ${DEPENDS} ${EXTRA_CP}
       cp=$cp:${STAGING_DIR_JAVA}/felix.jar
       echo "--- JAVAC CLASSPATH ---------------"
       echo $cp | awk 'BEGIN {FS=":"} {split($0,a,":"); for (i=1; i<=NF; i++) print a[i]; }'
       echo "-------------------------"
       javac -source 1.6 -d build -cp $cp ${JCFLAGS} org/freedesktop/*.java org/freedesktop/dbus/*.java  org/freedesktop/dbus/exceptions/*.java org/freedesktop/dbus/types/*.java
       (cd translations; for i in *.po; do echo ${i%.po}; echo $i; ${MSGFMT} --java2 -r dbusjava_localized -d ../build -l ${i%.po} $i; echo ${i%.po}; echo $i; done)
       ${MSGFMT} --java2 -r dbusjava_localized -d build translations/en_GB.po
       touch .classes
       javac ${JAVAC_OPTIONS} -sourcepath . -cp $cp -d build `find . -name \*.java`
}
