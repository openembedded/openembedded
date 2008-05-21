require cacao.inc

PR = "r0"

SRC_URI = "http://downloads.openmoko.org/sources/cacao-0.98+hg8190.tar.gz;md5sum=1c6e0530be63ec8a4c0ab2935c2fdc8f \
           file://cacao-hg8190-classpath_var.patch;patch=1 \
           file://cacao-hg8190-libdir.patch;patch=1 \
          "

S = "${WORKDIR}/cacao"

EXTRA_OECONF = "\
        ${@['','--enable-softfloat'][bb.data.getVar('TARGET_FPU',d,1) == 'soft']} \
        --enable-debug \
        --with-vm-zip=${datadir}/cacao/vm.zip \
        --with-cacaoh=${STAGING_BINDIR_NATIVE}/cacaoh-${PV} \
        --with-java-runtime-library-classes=${STAGING_DATADIR}/classpath/glibj.zip \
        --with-target-java-runtime-library-classes=${datadir}/classpath/glibj.zip \
        --with-java-runtime-library-libdir=${libdir} \
        --with-jni_md_h=${STAGING_INCDIR}/classpath \
        --with-jni_h=${STAGING_INCDIR}/classpath \
        "

DEFAULT_PREFERENCE = "-1"
