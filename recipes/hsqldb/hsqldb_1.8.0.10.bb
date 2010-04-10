DESCRIPTION = "Lightweight 100% Java SQL Database Engine"
# BSD-like
LICENSE = "HypersonicSQL"

AUTHOR = "HSQLDB Development Group"
HOMEPAGE = "http://hsqldb.org"

SRC_URI = "${SOURCEFORGE_MIRROR}/hsqldb/hsqldb_1_8_0_10.zip"

S = "${WORKDIR}/${PN}"

inherit java-library

DEPENDS = "fastjar-native servlet2.4"

do_compile() {
  # Build instructions according to build/buildJDK14.bat
	mkdir -p classes

	oe_makeclasspath cp -s servlet-api-2.4

	javac -sourcepath src -cp $cp -d build `find src -name "*.java" -and -not -wholename "*test*"`

	mkdir -p classes/org/hsqldb/util
	mkdir -p classes/org/hsqldb/util/sqltool
	mkdir -p classes/org/hsqldb/resources

	cp src/org/hsqldb/util/*.gif classes/org/hsqldb/util/
	cp src/org/hsqldb/util/*.png classes/org/hsqldb/util/
	cp src/org/hsqldb/util/*.properties classes/org/hsqldb/util/
	cp src/org/hsqldb/util/sqltool/*.text classes/org/hsqldb/util/sqltool/

	cp src/org/hsqldb/resources/*.properties classes/org/hsqldb/resources

  fastjar -C classes -c -f ${JARFILENAME} .
}

SRC_URI[md5sum] = "17410483b5b5f267aa18b7e00b65e6e0"
SRC_URI[sha256sum] = "d30b13f4ba2e3b6a2d4f020c0dee0a9fb9fc6fbcc2d561f36b78da4bf3802370"
