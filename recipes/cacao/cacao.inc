DESCRIPTION = "Cacao is a Java Virtual Machine, which uses GNU Classpath as default Java core library"
HOMEPAGE = "http://www.cacaojvm.org/"
LICENSE  = "GPL"
PRIORITY = "optional"
SECTION  = "interpreters"

DEPENDS = "zlib libtool classpath cacaoh-native virtual/javac-native"

PR = "r1"

# Avoid version number here, otherwise dpkg will expect a package name
# and cannot be satisfied with a package that provides classpath.
RDEPENDS_${PN} = "classpath"

RPROVIDES_cacao = "java2-runtime"

inherit java autotools update-alternatives

ARM_INSTRUCTION_SET = "arm"

PRIVATE_LIBS = "libjvm.so"

# Configure options compatible with Cacao >= 0.99 only!
EXTRA_OECONF = "\
	${@['','--enable-softfloat'][bb.data.getVar('TARGET_FPU',d,1) == 'soft']} \
	--enable-debug \
	--with-vm-zip=${datadir}/cacao/vm.zip \
	--with-cacaoh=${STAGING_BINDIR_NATIVE}/cacaoh-${PV}/cacaoh \
    --with-build-java-runtime-library-classes=${STAGING_DATADIR}/classpath/glibj.zip \
    --with-java-runtime-library-classes=${datadir}/classpath/glibj.zip \
    --with-java-runtime-library-libdir=${libdir_jni}:${libdir} \
    --with-jni_md_h=${STAGING_INCDIR}/classpath \
    --with-jni_h=${STAGING_INCDIR}/classpath \
	--libdir=${libdir}/cacao \
"

PACKAGES = "${PN} ${PN}-doc ${PN}-dbg"

FILES_${PN} = "${bindir}/${PN} ${libdir}/cacao/lib*.so ${libdir}/lib*.so* ${datadir}/${PN}"
FILES_${PN}-doc = "${datadir}/man"
FILES_${PN}-dbg += "${bindir}/.debug ${libdir}/.debug/lib*.so*"

ALTERNATIVE_NAME = "java"
ALTERNATIVE_LINK = "${bindir}/${ALTERNATIVE_NAME}"
ALTERNATIVE_PATH = "${bindir}/cacao"
ALTERNATIVE_PRIORITY = "10"
