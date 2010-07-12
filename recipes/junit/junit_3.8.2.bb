DESCRIPTION = "JUnit is a testing framework for Java"
LICENSES = "CPL"
AUTHOR = "junit.org"
HOMEPAGE = "http://www.junit.org"

SRC_URI = "http://downloads.sourceforge.net/junit/junit${PV}.zip"

S = "${WORKDIR}/junit${PV}"

inherit java-library

DEPENDS = "fastjar-native"

do_unpackpost() {
	mkdir -p src

	# Prevent deletion by do_removebinaries.
	mv src.jar src.zip

	unzip src.zip -d src
}

addtask unpackpost before do_removebinaries after do_unpack

do_compile() {
  mkdir -p build

	# Workaround for jamvm.
	bcp=${STAGING_DATADIR_NATIVE}/classpath/glibj.zip

  javac -bootclasspath $bcp -sourcepath src -d build `find src -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}
