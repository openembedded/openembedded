DESCRIPTION = "SWT is an open source widget toolkit for Java designed to provide efficient, portable access to the user-interface facilities"
LICENSE = "CPL MPL LGPL"

inherit java-library

# classpath provides jni.h which is needed herein
DEPENDS = "fastjar-native cairo gtk+ atk libxtst classpath"

S = "${WORKDIR}/swt-source"

# A number which is used by SWT to mark the shared libraries. It can be found
# in the version.txt file inside the source directory.
SWT_API_VERSION = ${@bb.fatal('SWT_API_VERSION is not defined in this swt-gtk recipe!')}

do_unpackpost() {
  if [ ! -d ${S} ]; then
    mkdir ${S}
    cd ${S}
  fi

  unzip -o ../src.zip
  cp ../Makefile .

  # Sets version numbers for native libraries.
  sed -i -e "s|RELEASE=OE_SWT_RELEASE|RELEASE=${PV}|" Makefile
  sed -i -e "s|SONAME_VERSION=OE_SWT_API_VERSION|SONAME_VERSION=${SWT_API_VERSION}|" Makefile

  # Properly applies OE's LDFLAGS to linking step.
  sed -i -e "s|LIBS = -shared -fPIC|LIBS = -shared ${LDFLAGS}|" make_linux.mak
}

do_compile() {
  oe_runmake NATIVE_STATS="-I${STAGING_INCDIR}/classpath"
}

addtask unpackpost after do_unpack before do_patch

do_install() {
  local swtversion=`cat version.txt | tr -d "version. "`

  oe_jarinstall swt-gtk-${PV}.jar swt-gtk.jar swt.jar

  oe_libinstall -so libswt-atk-gtk-$swtversion ${D}/${libdir_jni}
  oe_libinstall -so libswt-cairo-gtk-$swtversion ${D}/${libdir_jni}  
  oe_libinstall -so libswt-pi-gtk-$swtversion ${D}/${libdir_jni}
  oe_libinstall -so libswt-gtk-$swtversion ${D}/${libdir_jni}
}

do_stage() {
  oe_jarinstall -s swt-gtk-${PV}.jar swt-gtk.jar swt.jar
}

PACKAGES += "lib${PN}-jni"

FILES_lib${PN}-jni = "${libdir_jni}/lib*.so*"

RDEPENDS_${JPN} = "lib${PN}-jni"
RPROVIDES_${JPN} = "libswt${SWT_API_VERSION}-gtk-java"

