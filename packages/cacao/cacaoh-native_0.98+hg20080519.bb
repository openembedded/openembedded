require cacaoh-native.inc

PR = "r0"

SRC_URI = "http://downloads.openmoko.org/sources/cacao-0.98+hg20080519.tar.gz;md5sum=1c6e0530be63ec8a4c0ab2935c2fdc8f"

S = "${WORKDIR}/cacao"

EXTRA_OECONF = " \
        --with-java-runtime-library-classes=${STAGING_DATADIR}/classpath/glibj.zip \
        --with-jni_md_h=${STAGING_INCDIR}/classpath \
        --with-jni_h=${STAGING_INCDIR}/classpath \
    "

DEFAULT_PREFERENCE = "-1"
