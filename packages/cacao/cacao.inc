DESCRIPTION = "Cacao is a Java Virtual Machine, which uses GNU Classpath as default Java core library"
HOMEPAGE = "http://www.cacaojvm.org/"
LICENSE  = "GPL"
PRIORITY = "optional"
SECTION  = "interpreters"

DEPENDS = "zlib libtool classpath cacaoh-native virtual/javac-native"

# Avoid version number here, otherwise dpkg will expect a package name
# and cannot be satisfied with a package that provides classpath.
RDEPENDS = "classpath"

PROVIDES = "cacao virtual/java"
RPROVIDES_cacao = "java2-runtime"

inherit autotools update-alternatives

EXTRA_OECONF = "\
	${@['','--enable-softfloat'][bb.data.getVar('TARGET_FPU',d,1) == 'soft']} \
	--enable-debug \
	--with-cacaoh=${STAGING_BINDIR_NATIVE}/cacaoh-${PV} \
	--with-classpath-libdir=${STAGING_LIBDIR}/classpath \
	--with-classpath-includedir=${STAGING_INCDIR}/classpath \
	--with-classpath-classes=${STAGING_DATADIR}/classpath/glibj.zip \
	--with-target-classpath-classes=${datadir}/classpath/glibj.zip \
	--with-vm-zip=${datadir}/cacao/vm.zip \
	--with-classpath-libdir=${libdir} \
	"

PACKAGES = "${PN} ${PN}-doc ${PN}-dbg"

FILES_${PN} = "${bindir}/${PN} ${libdir}/lib*.so* ${datadir}/${PN}"
FILES_${PN}-doc = "${datadir}/man"
FILES_${PN}-dbg = "${bindir}/.debug ${libdir}/.debug/lib*.so*"

ALTERNATIVE_NAME = "java"
ALTERNATIVE_LINK = "${bindir}/${ALTERNATIVE_NAME}"
ALTERNATIVE_PATH = "${bindir}/cacao"
ALTERNATIVE_PRIORITY = "10"

do_configure_prepend() {
  # Replaces the placeholder OE_LIBDIR_JNI with the JNI library directory
  # configured in OE.
  if [ -e src/vm/properties.c ]; then
    sed -i -e "s|OE_LIBDIR_JNI|${libdir}/jni|" src/vm/properties.c
  fi

  if [ -e src/vm/properties.c ]; then
    sed -i -e "s|OE_LIBDIR_JNI|${libdir}/jni|" src/vm/vm.c
  fi
}

