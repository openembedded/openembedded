DESCRIPTION = "Java runtime based upon the OpenJDK- and Icedtea Project"
HOMEPAGE = "http://icedtea.classpath.org"
LICENSE  = "GPL with Classpath Exception"
PRIORITY = "optional"
SECTION  = "libs"

# Name of the icedtea tarball and top-level directory.
ICEDTEA = "NEEDS TO BE SET"

S = "${WORKDIR}/${ICEDTEA}"
B = "${S}/build"

INC_PR = "r11"

SRC_URI = "\
  ${ICEDTEA_URI} \
  ${OPENJDK_URI} \
  ${JAXWS_URI} \
  ${JAF_URI} \
  ${JAXP_URI} \
  ${CACAO_URI} \
  ${OEPATCHES} \
  ${ICEDTEAPATCHES} \
  file://jvm.cfg \
  "

JDKPN = "openjdk-6"
JDK_DIR = "java-6-openjdk"

PN = "${JDKPN}-jre"
PROVIDES += "${JDKPN} ${PACKAGES}"

DEPENDS = "giflib libpng jpeg cups \
	   xalan-j xerces-j rhino \
	   freetype libxinerama libxt libxp libxrender libxtst libxi \
	   ant-native alsa-lib libffi \
	   icedtea6-native fastjar \
           llvm2.7 cacaoh-openjdk-native \
           zip-native \
	 "

# The OpenJDK build with interpreter optimizations for ARM depends on a binary
# that generates constants for an assembler source file. There is no other
# way than to generate this on a pseudo machine. Cross-compiling would not help
# because structure sizes and/or alignment may differ.
DEPENDS_append_arm = " qemu-native "


FILESPATHPKG =. "openjdk-6-${PV}:"

# No package should directly depend on this (it should require
# java2-runtime instead).
PRIVATE_LIBS = "\
	libunpack.so libverify.so libjava.so libzip.so libnpt.so \ 
	libjava_crw_demo.so libhprof.so libnet.so libnio.so \
	libmanagement.so libinstrument.so libjsound.so libjsoundalsa.so \
	libj2pcsc.so libj2pkcs11.so libj2gss.so libmlib_image.so \
	libawt.so libsplashscreen.so libfreetype.so.6 libfontmanager.so \
	libjpeg.so liblcms.so librmi.so libjawt.so libjaas_unix.so \
	libattach.so libjdwp.so libdt_socket.so libhpi.so libjli.so \
	libmawt.so libjvm.so \
	libversionCheck.so libcompiledMethodLoad.so libgctest.so \
	libheapViewer.so libheapTracker.so libminst.so libmtrace.so \
	libwaiters.so libhprof.so \
"


inherit java autotools

export ALT_CUPS_HEADERS_PATH = "${STAGING_INCDIR}"
export ALT_FREETYPE_HEADERS_PATH = "${STAGING_INCDIR}/freetype2"
export ALT_FREETYPE_LIB_PATH = "${STAGING_LIBDIR}"
export CACAO_CONFIGURE_ARGS = "\
	${@['','--enable-softfloat'][bb.data.getVar('TARGET_FPU',d,1) == 'soft']} \
	--with-cacaoh=${STAGING_BINDIR_NATIVE}/cacaoh-openjdk-0.99.4"

JAVA_HOME[unexport] = "1"

EXTRA_OECONF = "\
	--disable-docs \
	--disable-pulse-java \
        --disable-plugin \
	\
	--with-ecj=${STAGING_BINDIR_NATIVE}/foo \
	--with-ecj-jar=${STAGING_DATADIR_JAVA_NATIVE}/ecj-bootstrap.jar \
	--with-java=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/bin/java \
	--with-javac=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/bin/javac \
	--with-javah=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/bin/javah \
	--with-jar=${STAGING_BINDIR_NATIVE}/fastjar \
	--with-rmic=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/bin/rmic \
	--with-xalan2-jar=${STAGING_DATADIR_JAVA}/xalan2.jar \
	--with-xalan2-serializer-jar=${STAGING_DATADIR_JAVA}/serializer.jar \
	--with-xerces2-jar=${STAGING_DATADIR_JAVA}/xercesImpl.jar \
	--with-rhino=${STAGING_DATADIR_JAVA}/rhino.jar \
	--with-openjdk-src-dir=${WORKDIR}/openjdk-src-dir \
	--with-gcj-home=${WORKDIR}/fake-jdk \
	--with-parallel-jobs=${JDK_JOBS} \
	\
	--with-libgcj-jar=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/jre/lib/rt.jar \
	\
	--with-pkgversion=${PV} \
	--with-cc-for-build=${BUILD_CC} \
        --enable-zero \
        --with-additional-vms=shark,cacao \
        --enable-openjdk-cross-compilation \
       "


# OpenJDK uses slightly different names for certain arches. We need to know
#	this to create some files which are expected by the build.
def get_jdk_arch(d):
  import bb

  jdk_arch = bb.data.getVar('TARGET_ARCH', d, 1)
  if jdk_arch == "x86_64":
    jdk_arch = "amd64"
  elif (jdk_arch == "i586" or jdk_arch == "i686"):
    jdk_arch = "i586"

  return jdk_arch

JDK_ARCH = "${@get_jdk_arch(d)}"
JDK_HOME = "${libdir_jvm}/${JDK_DIR}"

# OpenJDK supports parallel compilation but uses a plain number for this.
# In OE we have PARALLEL_MAKE which is the actual option passed to make,
# e.g. "-j 4". 
def get_jdk_jobs(d):
	import bb

	pm = bb.data.getVar('PARALLEL_MAKE', d, 1);
	if not pm:
		return "1"
	
	pm = pm.split(" ");
	if (len(pm) == 2):
		return pm[1]

	# Whatever found in PARALLEL_MAKE was not suitable.
	return "1"

JDK_JOBS = "${@get_jdk_jobs(d)}"

# A function that is needed in the Shark builds.
def get_llvm_configure_arch(d):
  import bb;

  arch = bb.data.getVar('TARGET_ARCH', d, 1)
  if arch == "x86_64" or arch == "i486" or arch == "i586" or arch == "i686":
    arch = "x86"
  elif arch == "arm":
    arch = "arm"
  elif arch == "mipsel":
    arch = "mips"
  elif arch == "powerpc":
    arch = "powerpc"
  else:
    oefatal("Your target architecture is not supported by this recipe");

  return arch

# Custom preparation of the sources which:
# - cleans up the sources
# - copies the patches into the proper directory
# - prepares the FakeJDK directory structure
#DISABLED because of incompatibility with oe stable 2009: do_prepareconfigure () {
do_configure_prepend() {
  chmod -R ug+w ${WORKDIR}/openjdk-src-dir
  (cd ${WORKDIR}/openjdk-src-dir && sh ${S}/fsg.sh)

  # Automatically copy everything that starts with "icedtea" (or "cacao") and ends with
  # ".patch" into the patches directory.
  find ${WORKDIR} -maxdepth 1 -name "icedtea*.patch" -exec cp {} ${S}/patches \;
  find ${WORKDIR} -maxdepth 1 -name "cacao*.patch" -exec cp {} ${S}/patches \;

  # use now the rt.jar from icedtea6-native
  mkdir -p ${WORKDIR}/fake-jdk/jre/lib
  ln -sf ${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/jre/lib/rt.jar ${WORKDIR}/fake-jdk/jre/lib/rt.jar

  symlinked=false
  oenote "Creating symlinks for fake-jdk"
  mkdir -p ${WORKDIR}/fake-jdk/include
  for i in `find ${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/include` ;do
	bn=`basename $i`
	oenote "Symlinking: $bn"
    ln -sf $i ${WORKDIR}/fake-jdk/include/$bn;
	symlinked=true
  done

  # If the symlinks have not been created the built cannot continue. This
  # can happen if icedtea6-native is not ready at this point. The recipe
  # should make sure this is not the case but a little sanity checking
  # in such a complicated build can't be wrong.
  if [ x$symlinked = xfalse ]
  then
    oefatal "Build b0rken! Have not created any symlinks for fake-jdk!"
  else
	oenote "fake-jdk setup appears sane."
  fi
}

# Note: The following lines only work for OE.dev branch but cause an exception
# in oe stable's 2009 bitbake. As such the function is prepended to do_configure instead.
#addtask prepareconfigure after do_patch before do_configure
# Makes prepareconfigure depend on icedtea6-native having being staged.
#do_prepareconfigure[depends] += "icedtea6-native:do_populate_sysroot"


do_configure_append() {
	oe_runmake patch-ecj
}

# Work around broken variable quoting in oe-stable 2009 and provide the variable
# via the environment which then overrides the erroneous value that was written
# into '${ICETDEA}/Makefile'.
# Icedtea's makefile is not compatible to parallelization so we cannot allow
# passing a valid ${PARALLEL_MAKE} to it. OTOH OpenJDK's makefiles are
# parallelizable and we need ${PARALLEL_MAKE} to derive the proper value.
# The base for this quirk is that GNU Make only considers the last "-j" option.
EXTRA_OEMAKE = '-j 1 CC="${CC}" CCC="${CXX}" CPP="${CPP}" CXX="${CXX}" CC_FOR_BUILD="${BUILD_CC}"'

EXTRA_OEMAKE += ' \
                OE_CFLAGS="${TARGET_CFLAGS}" \
                OE_CPPFLAGS="${TARGET_CPPFLAGS}" \
                OE_CXXFLAGS="${TARGET_CXXFLAGS}" \
                OE_LDFLAGS="${TARGET_LDFLAGS}" \
                ZIPEXE="${STAGING_BINDIR_NATIVE}/zip" \
               '

# Puts an OE specific string into the binary making it possible for the user
# to know where it comes from (and blame the right people ...).
DIST_ID = "Built for ${DISTRO}"
DIST_NAME = "${DISTRO}"
EXTRA_OEMAKE += 'DIST_NAME="${DIST_NAME}" DIST_ID="${DIST_ID}"'


# llvm configure and compiles stuff

export WANT_LLVM_RELEASE = "2.7"

# Provides the target architecture to the configure script.
export LLVM_CONFIGURE_ARCH="${@get_llvm_configure_arch(d)}"

OE_LAUNCHER_LDFLAGS = "-Wl,-rpath-link,${STAGING_LIBDIR}/llvm2.7"

EXTRA_OEMAKE += 'OE_LAUNCHER_LDFLAGS="${OE_LAUNCHER_LDFLAGS}"'


# Large stack is required at least on x86_64 host, otherwise random segfaults appear:
QEMU = "qemu-${TARGET_ARCH} ${QEMU_OPTIONS} -s 1048576 -L ${STAGING_DIR_TARGET}"

EXTRA_OEMAKE += 'QEMU="${QEMU}"'

# Name of the directory containing the compiled output
BUILD_DIR = "build/linux-${JDK_ARCH}"

# The build of OpenJDK is a 3-part process. For better restartability and overrideability they have been split into
# three functions.
# 1. compile Hotspot or Cacao (this one is supposed to be implemented according to wanted VM)
# 2. compile openjdk-ecj (to have libraries as libjvm.so and libjava.so which are needed later)
# 3. compile openjdk (the final result)

do_compilestepone() {
        oe_runmake bootstrap-directory-ecj

        # now we need to override the tools.jar to point to the normal jdk's tools.jar
        rm bootstrap/ecj/lib/tools.jar
        ln -s ${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/lib/tools.jar bootstrap/ecj/lib/tools.jar

        # First build hotspot to get a libjvm.so (to link corba in the icedtea-ecj build)
        echo "1/3 Building Hotspot"
        oe_runmake hotspot

        # Remove spurious libarch directory/symlink
        rm -rf bootstrap/ecj/jre/lib/${JDK_ARCH} || true

                # Provide a symlink to the target arch's libjvm.so (to link against)
        ln -s `pwd`/openjdk-ecj/${BUILD_DIR}/j2sdk-image/jre/lib/${JDK_ARCH} bootstrap/jdk1.6.0/jre/lib/${JDK_ARCH}

        # fake j2sdk-image
        rm openjdk-ecj/${BUILD_DIR}/j2sdk-image/include || true
        cp -ar openjdk-ecj/${BUILD_DIR}/hotspot/import/include openjdk-ecj/${BUILD_DIR}/j2sdk-image/
        install -d openjdk-ecj/${BUILD_DIR}/j2sdk-image/bin
}
addtask compilestepone after do_configure before do_compilesteptwo

# This part can be shared between cacao and hotspot-zero builds.
do_compilesteptwo() {
	echo "2/3 Building bootstrap JDK"

	# Now cross-compile bootstrap JDK
	rm stamps/icedtea-against-ecj.stamp stamps/icedtea-ecj.stamp || true
	oe_runmake icedtea-against-ecj

	ln -sf ../openjdk-ecj/${BUILD_DIR}/j2sdk-image bootstrap/icedtea

	#	Replace all executables with symlinks to their native equivalents.
	for F in `find ${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/bin -type f`
	do
		bf=`basename $F`
		echo "Creating symlink for:" $bf
		ln -sf $F bootstrap/icedtea/bin/$bf
	done
}
addtask compilesteptwo after do_compilestepone before do_compile

do_compile() {

	echo "3/3 Building final JDK"

	# Build the final Hotspot + OpenJDK
	oe_runmake icedtea-against-icedtea \
}

do_install() {
	install -d ${D}${libdir_jvm}
	cp -R ${S}/build/openjdk/${BUILD_DIR}/j2sdk-image ${D}${JDK_HOME}

	chmod u+rw -R ${D}${JDK_HOME}

	# Fix symlink which would point into staging in the binary package.
	ln -sf ${datadir_java}/rhino.jar ${D}${JDK_HOME}/jre/lib/rhino.jar

	# JRE is a subset of JDK. So to save space and resemble what the BIG distros
	# do we create symlinks from the JDK binaries to their counterparts in the
	# JRE folder (which have to exist by that time b/c of dependencies). 
	for F in `find ${D}${JDK_HOME}/jre/bin -type f`
	do
		bf=`basename $F`
		echo "replace:" $bf
		rm ${D}${JDK_HOME}/bin/$bf
		ln -s ${JDK_HOME}/jre/bin/$bf ${D}${JDK_HOME}/bin/$bf
	done

        install -m644 ${WORKDIR}/jvm.cfg  ${D}${JDK_HOME}/jre/lib/${JDK_ARCH}/
}

# Manual staging step that is only needed for oe-stable.
do_stage() {
          :
}

# Notes about the ideas behind packaging:
# 1) User should install openjdk-6-jre. This is a provider of 'java2-runtime'.
# 2) This lets package mgmt install: openjdk-6-java
# -> openjdk-6-vm-shark|openjdk-6-vm-zero|openjdk-6-vm-cacao -> openjdk-6-common
#
# With opkg the zero VM is chosen which is good b/c that is the best known (= compatible)
# runtime. Installing other runtimes side-by-side is possible. Through jvm.cfg the following
# order of precedence is enforced: zero, shark, cacao. User can chose a different runtime
# by adding '-shark' or '-cacao' to the Java command (or by deinstalling an otherwise preferred
# runtime)
# 3) All other packages, including -jdk, are optional and not needed for normal Java apps.
PACKAGES = " \
            ${JDKPN}-jre \
            ${JDKPN}-dbg \
            ${JDKPN}-demo-dbg \
            ${JDKPN}-demo \
            ${JDKPN}-source \
            ${JDKPN}-doc \
            ${JDKPN}-jdk \
            ${JDKPN}-java \
            ${JDKPN}-vm-shark \
            ${JDKPN}-vm-zero \
            ${JDKPN}-vm-cacao \
            ${JDKPN}-common \
           "

FILES_${JDKPN}-dbg = "\
	${JDK_HOME}/bin/.debug \
	${JDK_HOME}/lib/.debug \
	${JDK_HOME}/jre/bin/.debug \
	${JDK_HOME}/jre/lib/.debug \
	${JDK_HOME}/jre/lib/${JDK_ARCH}/.debug \
	${JDK_HOME}/jre/lib/${JDK_ARCH}/jli/.debug \
	${JDK_HOME}/jre/lib/${JDK_ARCH}/native_threads/.debug \
	${JDK_HOME}/jre/lib/${JDK_ARCH}/server/.debug \
        ${JDK_HOME}/jre/lib/${JDK_ARCH}/shark/.debug \
	${JDK_HOME}/jre/lib/${JDK_ARCH}/headless/.debug \
	${JDK_HOME}/jre/lib/${JDK_ARCH}/xawt/.debug \
       "

FILES_${JDKPN}-demo = "${JDK_HOME}/demo ${JDK_HOME}/sample"
RDEPENDS_${JDKPN}-demo = "java2-runtime"
FILES_${JDKPN}-demo-dbg = "\
	${JDK_HOME}/demo/jvmti/gctest/lib/.debug \
	${JDK_HOME}/demo/jvmti/heapTracker/lib/.debug \
	${JDK_HOME}/demo/jvmti/heapViewer/lib/.debug \
	${JDK_HOME}/demo/jvmti/hprof/lib/.debug \
	${JDK_HOME}/demo/jvmti/minst/lib/.debug \
	${JDK_HOME}/demo/jvmti/mtrace/lib/.debug \
	${JDK_HOME}/demo/jvmti/versionCheck/lib/.debug \
	${JDK_HOME}/demo/jvmti/waiters/lib/.debug \
	${JDK_HOME}/demo/jvmti/compiledMethodLoad/lib/.debug \
       "

FILES_${JDKPN}-source = "${JDK_HOME}/src.zip"

FILES_${JDKPN}-java = "${JDK_HOME}/jre/bin/java"

FILES_${JDKPN}-vm-zero = "${JDK_HOME}/jre/lib/arm/server/"

FILES_${JDKPN}-vm-shark = "${JDK_HOME}/jre/lib/arm/shark/"

FILES_${JDKPN}-vm-cacao = "${JDK_HOME}/jre/lib/arm/cacao/"

FILES_${JDKPN}-common = "${JDK_HOME}/jre/ASSEMBLY_EXCEPTION \
                          ${JDK_HOME}/jre/THIRD_PARTY_README \
                          ${JDK_HOME}/jre/LICENSE \
                          ${JDK_HOME}/jre/lib \
                         "

FILES_openjdk-6-jre_append = " \
	${JDK_HOME}/jre/bin/keytool \
        ${JDK_HOME}/jre/bin/orbd \
	${JDK_HOME}/jre/bin/pack200 \
        ${JDK_HOME}/jre/bin/rmid \
	${JDK_HOME}/jre/bin/rmiregistry \
        ${JDK_HOME}/jre/bin/servertool \
	${JDK_HOME}/jre/bin/tnameserv \
        ${JDK_HOME}/jre/bin/unpack200 \
	${JDK_HOME}/jre/bin/policytool \
        ${JDK_HOME}/jre/bin/javaws \
       "

RDEPENDS_${JDKPN}-common = "librhino-java"

RPROVIDES_${JDKPN}-vm-shark = "java2-vm"
RPROVIDES_${JDKPN}-vm-zero = "java2-vm"
RPROVIDES_${JDKPN}-vm-cacao = "java2-vm"

RDEPENDS_${JDKPN}-java = "java2-vm"

# For some reason shark and cacao do not automatically depends on -common.
# So we add that manually.
RDEPENDS_${JDKPN}-vm-shark = "${JDKPN}-common"
RDEPENDS_${JDKPN}-vm-cacao = "${JDKPN}-common"

# There is a symlink to a .so but this one is valid.
INSANE_SKIP_${JDKPN}-vm-shark = "1"
INSANE_SKIP_${JDKPN}-vm-zero = "1"
INSANE_SKIP_${JDKPN}-vm-cacao = "1"
INSANE_SKIP_${JDKPN}-common = "1"

FILES_${JDKPN}-jdk = " \
                       ${JDK_HOME}/bin \
                       ${JDK_HOME}/lib \
                       ${JDK_HOME}/include \
                      "
RDEPENDS_${JDKPN}-jre = "${JDKPN}-java"
RPROVIDES_${JDKPN}-jre = "java2-runtime"

RDEPENDS_${JDKPN}-jdk = "${JDKPN}-jre"

FILES_${JDKPN}-doc = "${JDK_HOME}/man"

pkg_postinst_${JDKPN}-vm-shark () {
        if  grep -q "\-cacao KNOWN" ${JDK_HOME}/jre/lib/arm/jvm.cfg && grep -q "\-server ERROR" ${JDK_HOME}/jre/lib/arm/jvm.cfg; then
          sed -i -e "/\-cacao KNOWN/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg
          echo "-cacao KNOWN" >> ${JDK_HOME}/jre/lib/arm/jvm.cfg
        fi 

	sed -i -e "/\-shark.*/d" -e "s|\(^\-server*\)|\-shark KNOWN\n\1|" -e "/^$/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg
}

pkg_prerm_${JDKPN}-vm-shark () {
	sed -i -e "/^\-shark.*/d" -e "/^$/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg 
        if  grep -q "\-cacao KNOWN" ${JDK_HOME}/jre/lib/arm/jvm.cfg && grep -q "\-server ERROR" ${JDK_HOME}/jre/lib/arm/jvm.cfg; then
          sed -i -e "/\-cacao KNOWN/d" -e  "s|\(^\-server*\)|\-cacao KNOWN\n\1|" ${JDK_HOME}/jre/lib/arm/jvm.cfg
        fi
}

pkg_postinst_${JDKPN}-vm-cacao () {
        if  grep -q "\-server ERROR" ${JDK_HOME}/jre/lib/arm/jvm.cfg && ! grep -q "\-shark KNOWN" ${JDK_HOME}/jre/lib/arm/jvm.cfg; then
          sed -i -e "/\-cacao.*/d" -e  "s|\(^\-server*\)|\-cacao KNOWN\n\1|" -e "/^$/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg
        else 
	  sed -i -e "s|^\-cacao.*|\-cacao KNOWN|" -e "/^$/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg
        fi
}

pkg_prerm_${JDKPN}-vm-cacao () {
     if  grep -q "\-server ERROR" ${JDK_HOME}/jre/lib/arm/jvm.cfg && ! grep -q "\-shark KNOWN" ${JDK_HOME}/jre/lib/arm/jvm.cfg; then
	sed -i -e "/\-cacao.*/d" -e "/^$/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg
        echo "-cacao ERROR" >> ${JDK_HOME}/jre/lib/arm/jvm.cfg
      else
	sed -i -e "s|^\-cacao.*|\-cacao ERROR|" -e "/^$/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg
      fi
}

pkg_postinst_${JDKPN}-vm-zero () {
 if  grep -q "\-cacao KNOWN" ${JDK_HOME}/jre/lib/arm/jvm.cfg  && ! grep -q "\-shark KNOWN" ${JDK_HOME}/jre/lib/arm/jvm.cfg; then
   sed -i -e "/\-cacao KNOWN/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg
   echo "-cacao KNOWN" >> ${JDK_HOME}/jre/lib/arm/jvm.cfg
 fi

 sed -i -e "s|^\-server.*|\-server KNOWN|" -e "/^$/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg
}

pkg_prerm_${JDKPN}-vm-zero () {
 if  grep -q "\-cacao KNOWN" ${JDK_HOME}/jre/lib/arm/jvm.cfg  && ! grep -q "\-shark KNOWN" ${JDK_HOME}/jre/lib/arm/jvm.cfg; then
   sed -i -e "/\-cacao KNOWN/d" -e  "s|\(^\-server*\)|\-cacao KNOWN\n\1|" ${JDK_HOME}/jre/lib/arm/jvm.cfg
 fi

 sed -i -e "s|^\-server.*|\-server ERROR|" -e "/^$/d" ${JDK_HOME}/jre/lib/arm/jvm.cfg
}

pkg_postinst_${JDKPN}-jre () {
	update-alternatives --install ${bindir}/java java ${JDK_HOME}/jre/bin/java 15
}

pkg_prerm_${JDKPN}-jre () {
	update-alternatives --remove java ${JDK_HOME}/jre/bin/java
}

pkg_postinst_${JDKPN}-jdk () {
	update-alternatives --install ${bindir}/javac javac ${JDK_HOME}/bin/javac 15
}

pkg_prerm_${JDKPN}-jdk () {
	update-alternatives --remove javac ${JDK_HOME}/bin/javac
}
