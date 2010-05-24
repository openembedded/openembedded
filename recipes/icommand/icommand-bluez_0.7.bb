DESCRIPTION = "iCommand bluez binding"
LICENSE = "LGPL"
SECTION = "libs"
HOMEPAGE = "http://sourceforge.net/projects/nxtcommand/"
AUTHOR = "Brian Bagnall <bbagnall at users.sourceforge.net>"

inherit java

SRC_URI = "\
    svn://nxtcommand.svn.sourceforge.net/svnroot/nxtcommand;module=icommand-projects/trunk/icommand-bluez;rev=134;proto=https \
    file://makefile.patch \
    "

DEPENDS = "bluez-libs"

S = "${WORKDIR}/icommand-projects/trunk/icommand-bluez/Release"

do_compile() {
  oe_runmake -f makefile clean
  oe_runmake -f makefile all \
    INCLUDES="-I${STAGING_INCDIR}/classpath " \
    LIBS="-lbluetooth"
}

do_install() {
  oe_libinstall -so libicmdbluez  ${D}${libdir_jni}
}

PACKAGES = "${PN}-jni ${PN}-jni-dbg"

RDEPENDS_${PN}-jni = "bluez-libs"

FILES_${PN}-jni = "${libdir_jni}/lib*.so"
FILES_${PN}-jni-dbg = "${libdir_jni}/.debug/lib*.so"
