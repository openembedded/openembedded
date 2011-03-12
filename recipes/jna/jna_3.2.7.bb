DESCRIPTION = "Java library to dynamically access native libraries"
LICENSES = "LGPL"

HOMEPAGE = "https://jna.dev.java.net"

SRC_URI = "\
	https://svn.java.net/svn/jna~svn/tags/${PV}/jnalib/dist/src.zip;subdir=${P} \
	file://omit-native.patch \
	"

SRC_URI[md5sum] = "ebc750bf7d1cd8148ad5d5b07adaf762"
SRC_URI[sha256sum] = "2b32ed48744ffa1d0887c66af74ae9b6c3bfe9023933543a0e2e2ae052dff376"

inherit java-library

DEPENDS = "ant-native virtual/java-native libffi"
RDEPENDS_${JPN} = "lib${PN}-jni"

do_compile() {
	# 'jar' target was patched to not include 'native' (so we have to do a steps on our own now).
	ant -Dbuild=build compile javah jar

	# Move created jar into subdir and give it proper name
	mv build/jna.jar ${JARFILENAME}

	# Native compilation in build.xml is overly complex. With full control of the
	# output directories we just do it on our own.
	${CC} ${CFLAGS} ${LDFLAGS} -shared -fPIC -o libjnidispatch.so \
		native/dispatch.c \
		native/callback.c \
		-Ibuild/native \
		-I${STAGING_INCDIR}/classpath \
		-lffi
}

do_install_append() {
	install -d ${D}${libdir_jni}
	oe_libinstall libjnidispatch ${D}${libdir_jni}
}

PACKAGES += "lib${PN}-jni-dbg lib${PN}-jni"

FILES_lib${PN}-jni-dbg = "${libdir_jni}/.debug"
FILES_lib${PN}-jni = "${libdir_jni}"
