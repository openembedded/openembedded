DESCRIPTION = "Harness to build the source code from OpenJDK using Free Software build tools"
HOMEPAGE = "http://icedtea.classpath.org"
LICENSE  = "GPL with Classpath Exception"
INC_PR = "r4"

DEPENDS = "virtual/javac-native classpath-tools-native \
	   virtual/java-native classpath-native \
	   xalan-j-native xerces-j-native rhino-native \
	   ant-native \
           libx11-native xproto-native libxt-native libxext-native \
	   freetype-native zlib-native giflib-native jpeg-native \
           zip-native \
	  "

inherit native java autotools

JAVA_HOME[unexport] = "1"

# No parallel build yet.
PARALLEL_MAKE = ""

# openjdk-ecj looks in /usr/include and /usr/lib for freetype by default.
export ALT_FREETYPE_HEADERS_PATH = "${STAGING_INCDIR}/freetype2"
export ALT_FREETYPE_LIB_PATH = "${STAGING_LIBDIR}"

# Configure options compatible with Cacao >= 0.99 only!
EXTRA_OECONF = "\
	--with-parallel-jobs=1 \
	--disable-docs \
	--disable-pulse-java \
	--disable-plugin \
        --disable-npplugin \
	--disable-xrender \
	\
	--with-ecj=${STAGING_BINDIR_NATIVE}/ecj-bootstrap \
	\
	--with-ecj-jar=${STAGING_DATADIR_JAVA_NATIVE}/ecj-bootstrap.jar \
	--with-java=${STAGING_BINDIR_NATIVE}/java \
	--with-javac=${STAGING_BINDIR_NATIVE}/ecj-bootstrap \
	--with-javah=${STAGING_BINDIR_NATIVE}/gjavah \
	--with-jar=${STAGING_BINDIR_NATIVE}/fastjar \
	--with-rmic=${STAGING_BINDIR_NATIVE}/grmic \
	--with-xalan2-jar=${STAGING_DATADIR_NATIVE}/java/xalan2.jar \
	--with-xalan2-serializer-jar=${STAGING_DATADIR_NATIVE}/java/serializer.jar \
	--with-xerces2-jar=${STAGING_DATADIR_NATIVE}/java/xercesImpl.jar \
	--with-rhino=${STAGING_DATADIR_NATIVE}/java/rhino.jar \
	--with-openjdk-src-dir=${WORKDIR}/openjdk-src-dir \
	--with-gcj-home=${WORKDIR}/fake-jdk \
	\
	--enable-openjdk-cross-compilation \
  "

JDK_DIR = "icedtea6-native"

JDK_INSTALL_DIR = "${D}/${libdir_jvm}/${JDK_DIR}"

do_configure_prepend() {

        case "${TARGET_ARCH}" in
                x86_64)
                        libarch=amd64
                ;;
                i386|i486|i586|i686)
                        libarch=x86
                ;;
                *)
                        arch=${TARGET_ARCH}
                        libarch=${TARGET_ARCH}
                ;;
        esac
 
	chmod -R ug+w ${WORKDIR}/openjdk-src-dir
	(cd ${WORKDIR}/openjdk-src-dir && sh ${S}/fsg.sh)

	# Automatically copy everything that starts with "icedtea" and ends with
	# ".patch" into the patches directory.
	find ${WORKDIR} -maxdepth 1 -name "icedtea*.patch" -exec cp {} ${S}/patches \;

	# Prepare JDK-like directory with Classpath' files which we can treat as a
	# SYSTEM_GCJ_DIR afterwards.
	mkdir -p ${WORKDIR}/fake-jdk/jre/lib/${libarch}
	ln -sf ${STAGING_DATADIR_NATIVE}/classpath/glibj.zip ${WORKDIR}/fake-jdk/jre/lib/${libarch}/rt.jar

	mkdir -p ${WORKDIR}/fake-jdk/include
	for i in ${STAGING_INCDIR_NATIVE}/classpath/* ;do
		test -r $i | continue;
		bn=`basename $i`
		ln -sf $i ${WORKDIR}/fake-jdk/include/$bn;
	done
}

do_configure_append() {
	oe_runmake patch-ecj

	for F in openjdk-ecj/jdk/make/common/shared/Compiler-gcc.gmk openjdk-ecj/corba/make/common/shared/Compiler-gcc.gmk ;
	do
		sed -i \
			-e"s|\$(COMPILER_PATH)gcc\$(GCC_SUFFIX)|${CC}|" \
			-e"s|\$(COMPILER_PATH)gcc\$(GCC_SUFFIX) -E|${CPP}|" \
			-e"s|\$(COMPILER_PATH)g++\$(GCC_SUFFIX)|${CXX}|" \
			$F
	done

	for F in openjdk-ecj/hotspot/make/linux/makefiles/gcc.make openjdk-ecj/hotspot/agent/src/os/linux/Makefile ;
	do
		sed -i \
			-e"s|gcc\$(GCC_SUFFIX)|${CC}|" \
			-e"s|g++\$(GCC_SUFFIX)|${CXX}|" \
			$F
	done
}

EXTRA_OEMAKE = ' \
                ZIPEXE="${STAGING_BINDIR_NATIVE}/zip" \
               '

do_compile() {
	# OpenJDK uses slightly different names for certain arches. We need to know
	#	this to create some files which are expected by the build.
	case "${TARGET_ARCH}" in
		x86_64)
			arch=amd64
			libarch=amd64
		;;
		i386|i486|i586|i686)
			arch=x86
			libarch=x86
		;;
		*)
			arch=${TARGET_ARCH}
			libarch=${TARGET_ARCH}
		;;
	esac

        echo "libarch ist ${libarch}"

        install -d openjdk-ecj/control/build/linux-$arch/hotspot/import/jre/lib
        if [ $libarch != $arch ]; then
                # Something is strange with the directoy naming. OpenJDK uses both variants.
                ln -sf $libarch openjdk-ecj/control/build/linux-$arch/hotspot/import/jre/lib/$arch
        fi


	# First build hotspot to get a libjvm.so
	echo "1/2 Building Hotspot"
	oe_runmake hotspot

	# Remove the strange recursive symlink that is created here (If it is not there, then just skip this).
	rm -rf bootstrap/ecj/jre/lib/$libarch || true

	# Copy libjvm.so for target into bootstrap/jdk1.6.0/jre/lib
	install -d bootstrap/ecj/jre/lib/$libarch
	cp openjdk-ecj/build/linux-$arch/j2sdk-image/jre/lib/$libarch/server/libjvm.so bootstrap/ecj/jre/lib/$libarch

	# OpenJDK build expects these files to exist (by creating those files we pretend
	# that stuff was compiled)
	common_dir=openjdk-ecj/build/linux-$arch/tmp/sun
	for D in javax.sound/jsoundalsa sun.awt.X11/xawt sun.awt/jawt;
	do
		echo "creating $common_dir/$D/obj64/.files_compiled"
		install -d $common_dir/$D/obj64
		touch $common_dir/$D/obj64/.files_compiled

		echo "creating $common_dir/$D/obj/.files_compiled"
		install -d $common_dir/$D/obj
		touch $common_dir/$D/obj/.files_compiled
	done

	echo "2/2 Running make icedtea-against-ecj"
	oe_runmake icedtea-against-ecj
	
	# Creates a nice symlink which allows us to reach the created files easily.
	oe_runmake stamps/bootstrap-directory-symlink.stamp
}

do_install() {
	case "${TARGET_ARCH}" in
		x86_64)
			JDK_ARCH=amd64
		;;
		i386|i486|i586|i686)
			JDK_ARCH=x86
		;;
		*)
			JDK_ARCH=${TARGET_ARCH}
		;;
	esac

	install -d ${JDK_INSTALL_DIR}

	for F in bootstrap/icedtea/{bin,include,jre,lib}
	do
		cp -RL $F ${JDK_INSTALL_DIR}
	done

	install -d ${JDK_INSTALL_DIR}/include/hpi
	cp openjdk-ecj/jdk/src/solaris/hpi/export/*.h ${JDK_INSTALL_DIR}/include/hpi
	cp openjdk-ecj/jdk/src/share/hpi/export/*.h ${JDK_INSTALL_DIR}/include/hpi

	install -d ${JDK_INSTALL_DIR}/include/javavm
	cp openjdk-ecj/jdk/src/share/javavm/export/*.h ${JDK_INSTALL_DIR}/include/javavm
	cp openjdk-ecj/jdk/src/solaris/javavm/export/*.h ${JDK_INSTALL_DIR}/include/javavm

	install -d ${JDK_INSTALL_DIR}/generated
	cp generated/sun/awt/X11/generator/sizer.32 ${JDK_INSTALL_DIR}/generated

	# Fix libjvm.so dependency of libfontmanager.so
	ln -sf server/libjvm.so ${JDK_INSTALL_DIR}/jre/lib/${JDK_ARCH}/libjvm.so
	ln -sf server/libjvm.so ${JDK_INSTALL_DIR}/jre/lib/${JDK_ARCH}/libjvm.so.0

	# Fix missing write permissions on the files.
	chmod ug+w -R ${JDK_INSTALL_DIR}
}
