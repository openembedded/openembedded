
inherit native

require midpath_${PV}.bb

DEPENDS = "ecj-native fastjar-native classpath-minimal-native"
PROVIDES = "virtual/cldc-api-1.1"

PACKAGES = " "


do_configure() {
	:
}

do_compile() {
mkdir -p ${S}/dist

# Build CLDC1.1
# Build base classes
cd ${S}/external/cldc1.1/src
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath . -source 1.3 -target 1.1" || exit 1
make install JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath . -source 1.3 -target 1.1" CLASS_DIR=${S}/external/cldc1.1/classes || exit 1
# Build CLDC extra classes for MIDP2
cd ${S}/src/cldc-glue
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${S}/external/cldc1.1/classes -sourcepath ${S}/src/cldc-glue -source 1.3 -target 1.1"
make install JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${S}/external/cldc1.1/classes -source 1.3 -target 1.1" CLASS_DIR=${S}/external/cldc1.1/classes
# Make a jar 
fastjar cvf  ${S}/dist/cldc1.1.jar -C ${S}/external/cldc1.1/classes .
}

do_install() {
	:
}
