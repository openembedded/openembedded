
require cacao.inc

SRC_URI +="file://midpath.patch;patch=1 \
           file://offsets_make.patch;patch=1 \
	   file://classpath_var.patch;patch=1 \
	   file://libmath.patch;patch=1 \
	   file://arm_mmap.patch;patch=1 \
          "
SRC_URI_append_arm = "file://offset.h_arm.patch;patch=1"

DEPENDS = "cacaoh-cldc-native ecj-native classpath-minimal-native virtual/cldc-api-1.1 libtool zlib"
RDEPENDS = "virtual/cldc-api-1.1 libltdl"
RPROVIDES = "virtual/java"

EXTRA_OECONF += "--with-classpath-libdir=${STAGING_DATADIR}/classpath-minimal \
                 --with-classpath-includedir=${STAGING_INCDIR}/classpath-minimal \
		 --enable-jni \
                 --enable-java=cldc1.1 \
                 --with-classpath=cldc1.1 \
                 --with-classpath-classes=${STAGING_DATADIR}/java/cldc1.1.jar \
		 --with-target-classpath-classes=${datadir}/java/cldc1.1.jar \
		 --with-cacaoh=${STAGING_BINDIR_NATIVE}/cacaoh \
		 --disable-libjvm \
                "

PACKAGES = "${PN} ${PN}-doc ${PN}-dbg" 

FILES_${PN} = "${bindir}/cacao"
FILES_${PN}-doc = "${datadir}/man"
FILES_${PN}-dbg = "${bindir}/.debug"

ALTERNATIVE_NAME = "java"
ALTERNATIVE_PATH = "${bindir}/cacao"
ALTERNATIVE_PRIORITY = "10"
