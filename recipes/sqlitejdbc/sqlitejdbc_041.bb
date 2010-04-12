DESCRIPTION = "JDBC driver for sqlite"
LICENSE = "BSD"

AUTHOR = "David Crawshaw"
HOMEPAGE = "http://www.zentus.com/sqlitejdbc/"

SRC_URI = "\
	http://www.zentus.com/${PN}/dist/${PN}-v${PV}-src.tgz \
	"

S = "${WORKDIR}/${PN}-v${PV}"

inherit java-library

DEPENDS = "classpath-tools-native sqlite3 classpath"
RDEPENDS_${JPN} = "libsqlitejdbc-jni"

do_unpackpost() {
  mkdir build native
}

addtask unpackpost after do_unpack before do_patch

do_compile() {
  javac -sourcepath src -d build `find src/org -name "*.java" -and -not -name "*Nested*"`
  (cd src && find . -name "*.properties" -exec cp {} ../build/{} \;)
  fastjar -C build -c -f ${JARFILENAME} .

	gjavah -classpath build -jni -o native/NativeDB.h org.sqlite.NativeDB
  ${CC} ${CFLAGS} -c -o native/NativeDB.o src/org/sqlite/NativeDB.c -I${STAGING_INCDIR}/classpath -Inative
  ${CC} ${CFLAGS} ${LDFLAGS} -shared -lsqlite3 -o libsqlitejdbc.so native/NativeDB.o

  ${STRIP} libsqlitejdbc.so
}

do_install_append() {
	oe_libinstall -so libsqlitejdbc ${D}${libdir_jni}
}

do_install_append() {
	oe_libinstall -so libsqlitejdbc ${STAGING_LIBDIR_JNI}
}

PACKAGES += "libsqlitejdbc-jni"

FILES_libsqlitejdbc-jni = "${libdir_jni}"

SRC_URI[md5sum] = "11aad2f368734e1ff8e0ecc37710d4a9"
SRC_URI[sha256sum] = "c04bb15b650ffcda80ccd3526b325b49a1173b3421da22b16845aad4a8945c10"
