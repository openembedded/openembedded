inherit java

HOMEPAGE = "http://midpath.thenesis.org/"
LICENSE  = "GPL"
PRIORITY = "optional"
SECTION  = "interpreters"

DEPENDS = "virtual/javac-native classpath-tools-native classpath fastjar-native"

GLIBJ_ZIP = "${STAGING_DATADIR}/classpath/glibj.zip"

CLDC_JAR = "${STAGING_DATADIR}/midpath-cldc/midpath-cldc1.1.jar"

TARGET_CC_ARCH += "${LDFLAGS}"

do_unpackpost() {
	# Remove unneccessary binary bits.
  find lib -name "*.jar" -exec rm \{\} \;
}

addtask unpackpost after do_unpack before do_patch

midpath_build() {
  sh build.sh \
    --enable-fastjar \
    --with-j2se-jar ${GLIBJ_ZIP} \
    --with-jar=fastjar \
    --with-javac=javac \
    --with-cldc-jar=${CLDC_JAR} \
    --with-midpath-jar=${STAGING_DATADIR}/midpath/midpath.jar \
    --with-kxml="${STAGING_DATADIR_JAVA}/kxml2.jar:${STAGING_DATADIR_JAVA}/xmlpull.jar" \
    --with-jni-include="-I${STAGING_INCDIR}/classpath" \
    "$@"

}
