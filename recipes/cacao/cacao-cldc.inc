DESCRIPTION = "Cacao-cldc is a Java Virtual Machine, which uses MIDPath CLDC as default Java core library"
HOMEPAGE = "http://www.cacaojvm.org/"
LICENSE  = "GPL"
PRIORITY = "optional"
SECTION  = "interpreters"

DEPENDS = "zlib libtool classpath midpath-cldc cacaoh-cldc-native virtual/javac-native"

# Avoid version number here, otherwise dpkg will expect a package name
# and cannot be satisfied with a package that provides classpath.
RDEPENDS_${PN} = "midpath-cldc"

PROVIDES = "cacao-cldc virtual/java-cldc"
RPROVIDES_cacao-cldc = "java-cldc-runtime"

inherit autotools update-alternatives

EXTRA_OECONF = "\
	${@['','--enable-softfloat'][bb.data.getVar('TARGET_FPU',d,1) == 'soft']} \
	--enable-debug \
	--enable-jni \
	--disable-libjvm \
	--enable-java=cldc1.1 \
	--with-classpath=cldc1.1 \
	--with-classpath-classes=${STAGING_DATADIR}/midpath-cldc/midpath-cldc1.1.jar \
	--with-target-classpath-classes=${datadir}/midpath-cldc/midpath-cldc1.1.jar \
	--with-cacaoh=${STAGING_BINDIR_NATIVE}/cacaoh-cldc-${PV} \
	--with-classpath-libdir=${STAGING_LIBDIR}/classpath \
	--with-classpath-includedir=${STAGING_INCDIR}/classpath \
	--with-vm-zip=${datadir}/cacao-cldc/vm.zip \
	--libdir=${libdir}/cacao-cldc \
	--program-suffix=-cldc \
	"

S = "${WORKDIR}/cacao-${PV}"

PACKAGES = "${PN} ${PN}-doc ${PN}-dbg"

FILES_${PN} = "${bindir}/${PN} ${libdir}/lib*.so* ${datadir}/${PN}"
FILES_${PN}-doc = "${datadir}/man"
FILES_${PN}-dbg += "${bindir}/.debug ${libdir}/.debug/lib*.so*"

ALTERNATIVE_NAME = "java-cldc"
ALTERNATIVE_LINK = "${bindir}/${ALTERNATIVE_NAME}"
ALTERNATIVE_PATH = "${bindir}/cacao-cldc"
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

do_configure_append() {
  # Fix the executable name in the wrapper script.
  sed -i -e "s|exec cacao|exec cacao-cldc|" src/scripts/java.in
}

