DESCRIPTION = "CacaoVM for use as OpenEmbedded's Java VM"
HOMEPAGE = "http://www.cacaojvm.org/"
LICENSE  = "GPL"
PRIORITY = "optional"
SECTION  = "interpreters"

DEPENDS = "zlib-native libtool-native classpath-native ecj-initial-native fastjar-native"

PROVIDES = "virtual/java-native"

S = "${WORKDIR}/cacao-${PV}"

inherit native autotools

EXTRA_OECONF = "\
  --enable-debug \
  --with-vm-zip=${datadir}/cacao/vm.zip \
  \
  --with-classpath-libdir=${libdir_jni}:${libdir} \
  --with-classpath-includedir=${includedir}/classpath \
  --with-classpath-classes=${datadir}/classpath/glibj.zip \
  \
  --with-java-runtime-library-classes=${datadir}/classpath/glibj.zip \
  --with-java-runtime-library-libdir=${libdir_jni}:${libdir} \
  --with-jni_md_h=${includedir}/classpath \
  --with-jni_h=${includedir}/classpath \
  "

# force usage of ecj-initial
# Important: Not specifying the bootclasspath argument here is only supported
# for Cacao >= 0.99. Earlier Cacao may need the BCP set to a Java5-capable
# class library.
export JAVAC="${STAGING_BINDIR_NATIVE}/ecj-initial"

# force usage of fastjar
export JAR="fastjar"

do_configure_prepend () {
        # Remove old libtool macros.
        MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"
        for i in ${MACROS}; do
               rm -f src/mm/boehm-gc/m4/$i
               rm -f m4/$i
        done
	rm  ltmain.sh
	rm  libtool
	rm  src/mm/boehm-gc/ltmain.sh
	rm  src/mm/boehm-gc/libtool
}
